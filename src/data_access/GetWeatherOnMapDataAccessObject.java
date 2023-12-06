package data_access;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.get_weather_on_map.GetWeatherOnMapDataAccessInterface;
import use_case.get_weather_on_map.GetWeatherOnMapSettingDataAccessInterface;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetWeatherOnMapDataAccessObject implements GetWeatherOnMapDataAccessInterface {
    private final String pageURL;
    private final GetWeatherOnMapSettingDataAccessInterface GetSettingsDataAccessObject;

    public GetWeatherOnMapDataAccessObject() {
        this.pageURL = "src/data_access/mapPage.html";
        this.GetSettingsDataAccessObject = new GetSettingsDataAccessObject();
    }

    @Override
    public JPanel getWeatherOnMap() {
        final JFXPanel jfxPanel = new JFXPanel();

        Platform.runLater(() -> {
            WebView webView = new WebView();
            jfxPanel.setScene(new Scene(webView));

            String[] coordinates = getCoordinates(GetSettingsDataAccessObject.getSettings().getDefaultCity().split(",")[0]);
            String longitude;
            String latitude;
            if (coordinates != null) {
                longitude = coordinates[1];
                latitude = coordinates[0];
            } else {
                System.out.println("Coordinates not found.");
                // load default coordinates
                latitude = "43.6532";
                longitude = "79.3832";
            }

            String city = GetSettingsDataAccessObject.getSettings().getDefaultCity();

            try {
                String htmlContent = new String(Files.readAllBytes(Paths.get(pageURL)));

                // reason why honda1 and honda2 is because the html file has honda1 and honda2 has to be unique so that
                // it doesn't replace other words that are the same
                htmlContent = htmlContent.replace("honda1", latitude);
                htmlContent = htmlContent.replace("honda2", longitude);

                webView.getEngine().loadContent(htmlContent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(jfxPanel, BorderLayout.CENTER);

        panel.setPreferredSize(new Dimension(700, 500));
        return panel;
    }

    public static String[] getCoordinates(String city) {
        String apiUrl = "https://nominatim.openstreetmap.org/search?city=" + city + "&format=json";
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(apiUrl);
            String jsonResponse = EntityUtils.toString(httpClient.execute(request).getEntity());
            JSONArray jsonArray = new JSONArray(jsonResponse);

            if (!jsonArray.isEmpty()) {
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                String lat = jsonObject.getString("lat");
                String lon = jsonObject.getString("lon");
                return new String[]{lat, lon};
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
