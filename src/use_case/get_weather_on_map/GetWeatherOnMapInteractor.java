//package use_case.get_weather_on_map;
//
//import entity.Weather;
//import javafx.application.Platform;
//import javafx.embed.swing.JFXPanel;
//import javafx.scene.Scene;
//import javafx.scene.web.WebView;
//import use_case.get_weather.GetSettingsDataAccessInterface;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class GetWeatherOnMapInteractor implements GetWeatherOnMapInputBoundary{
//    final GetWeatherOnMapDataAccessInterface getWeatherOnMapDataAccessObject;
//    final GetWeatherOnMapOutputBoundary getWeatherOnMapPresenter;
//    final GetSettingsDataAccessInterface getSettingsDataAccessObject;
//
//    public GetWeatherOnMapInteractor(GetWeatherOnMapDataAccessInterface getWeatherOnMapDataAccessObject,
//                                     GetWeatherOnMapOutputBoundary getWeatherOnMapPresenter,
//                                     GetSettingsDataAccessInterface getSettingsDataAccessObject) {
//        this.getWeatherOnMapDataAccessObject = getWeatherOnMapDataAccessObject;
//        this.getWeatherOnMapPresenter = getWeatherOnMapPresenter;
//        this.getSettingsDataAccessObject = getSettingsDataAccessObject;
//    }
//
//    @Override
//    public void execute(GetWeatherOnMapInputData getWeatherOnMapInputData) {
//        JFXPanel jfxPanel = new JFXPanel();
//        Platform.runLater(() -> {
//            WebView webView = new WebView();
//            jfxPanel.setScene(new Scene(webView));
//            webView.getEngine().load("File:///src/use_case/get_weather_on_map/mapPage.html");
//        });
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//        panel.add(jfxPanel, BorderLayout.CENTER);
//
//        GetWeatherOnMapOutputData getWeatherOnMapOutputData = new GetWeatherOnMapOutputData(panel);
//        this.getWeatherOnMapPresenter.prepareWeatherPage(getWeatherOnMapOutputData);
//    }
//}
