//package data_access;
//
//import javafx.application.Platform;
//import javafx.embed.swing.JFXPanel;
//import javafx.scene.Scene;
//import javafx.scene.web.WebView;
//import use_case.get_weather_on_map.GetWeatherOnMapDataAccessInterface;
//import use_case.get_weather_on_map.GetWeatherOnMapSettingDataAccessInterface;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//public class GetWeatherOnMapDataAccessObject implements GetWeatherOnMapDataAccessInterface {
//    private final String pageURL;
//    private final GetWeatherOnMapSettingDataAccessInterface GetSettingsDataAccessObject;
//
//    public GetWeatherOnMapDataAccessObject() {
//        this.pageURL = "src/data_access/mapPage.html";
//        this.GetSettingsDataAccessObject = new GetSettingsDataAccessObject();
//    }
//
//    @Override
//    public JPanel getWeatherOnMap() {
//        final JFXPanel jfxPanel = new JFXPanel();
//
//        Platform.runLater(() -> {
//            WebView webView = new WebView();
//            jfxPanel.setScene(new Scene(webView));
//
//            String longitude = "39.9042";
//            String latitude = "116.4074";
//
//
//            String city = GetSettingsDataAccessObject.getSettings().getDefaultCity();
//
//            try {
//                String htmlContent = new String(Files.readAllBytes(Paths.get(pageURL)));
//
//                htmlContent = htmlContent.replace("honda1", longitude);
//                htmlContent = htmlContent.replace("honda2", latitude);
//
//                webView.getEngine().loadContent(htmlContent);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        });
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//        panel.add(jfxPanel, BorderLayout.CENTER);
//
//        return panel;
//    }
//}
