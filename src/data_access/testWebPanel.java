package data_access;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class testWebPanel {

    public static JPanel createWebPanel(String pageURL) {
        final JFXPanel jfxPanel = new JFXPanel();

        Platform.runLater(() -> {
            WebView webView = new WebView();
            jfxPanel.setScene(new Scene(webView));

//            File file = new File(pageURL);
//            try {
//                webView.getEngine().load(file.toURI().toURL().toString());
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            }

            String latitude = "39.9042";
            String longitude = "116.4074";

            try {
                String htmlContent = new String(Files.readAllBytes(Paths.get("src/data_access/mapPage.html")));

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

        return panel;
    }




    public static void main(String[] args) {
        // Ensures the JavaFX runtime is initialized
        Platform.startup(() -> {});

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("URL Viewer");
//            JPanel webPanel = createWebPanel("https://www.google.com/maps");
            JPanel webPanel = createWebPanel("src/use_case/get_weather_on_map/mapPage.html");
            frame.add(webPanel);
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

