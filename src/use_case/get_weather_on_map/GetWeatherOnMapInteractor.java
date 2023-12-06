package use_case.get_weather_on_map;

import entity.Weather;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import use_case.forecast.ForecastSettingsDataAccessInterface;
import use_case.get_weather.GetSettingsDataAccessInterface;
import view.RoundedPanel;

import javax.swing.*;
import java.awt.*;

import java.io.File;
import java.net.MalformedURLException;

public class GetWeatherOnMapInteractor implements GetWeatherOnMapInputBoundary{
    final GetWeatherOnMapDataAccessInterface getWeatherOnMapDataAccessObject;
    final GetWeatherOnMapOutputBoundary getWeatherOnMapPresenter;
    final GetWeatherOnMapSettingDataAccessInterface getSettingsDataAccessObject;

    public GetWeatherOnMapInteractor(GetWeatherOnMapDataAccessInterface getWeatherOnMapDataAccessObject,
                                     GetWeatherOnMapOutputBoundary getWeatherOnMapPresenter,
                                     GetWeatherOnMapSettingDataAccessInterface getSettingsDataAccessObject) {
        this.getWeatherOnMapDataAccessObject = getWeatherOnMapDataAccessObject;
        this.getWeatherOnMapPresenter = getWeatherOnMapPresenter;
        this.getSettingsDataAccessObject = getSettingsDataAccessObject;
    }

    @Override
    public void execute(GetWeatherOnMapInputData getWeatherOnMapInputData) {

        RoundedPanel panel = this.getWeatherOnMapDataAccessObject.getWeatherOnMap();

        GetWeatherOnMapOutputData getWeatherOnMapOutputData = new GetWeatherOnMapOutputData(panel);
        this.getWeatherOnMapPresenter.prepareWeatherPage(getWeatherOnMapOutputData);
    }
}
