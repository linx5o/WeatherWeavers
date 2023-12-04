package interface_adapter.Forecast;

import use_case.forecast.ForecastOutputBoundary;
import use_case.forecast.ForecastOutputData;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class  ForecastPresenter implements ForecastOutputBoundary {
    private final ForecastViewModel forecastViewModel;

    public ForecastPresenter(ForecastViewModel forecastViewModel) {
        this.forecastViewModel = forecastViewModel;
    }

    @Override
    public void prepareInformationForecast(ForecastOutputData forecast) {
        ForecastState state = forecastViewModel.getState();

        state.setForecast1(LocalDateTime.parse(forecast.getWeathers().get(0).getSunrise(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                .getDayOfWeek()
                .getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        state.setForecast2(LocalDateTime.parse(forecast.getWeathers().get(1).getSunrise(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                .getDayOfWeek()
                .getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        state.setForecast3(LocalDateTime.parse(forecast.getWeathers().get(2).getSunrise(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                .getDayOfWeek()
                .getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        state.setForecast4(LocalDateTime.parse(forecast.getWeathers().get(3).getSunrise(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                .getDayOfWeek()
                .getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        state.setForecast5(LocalDateTime.parse(forecast.getWeathers().get(4).getSunrise(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                .getDayOfWeek()
                .getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        state.setForecast6(LocalDateTime.parse(forecast.getWeathers().get(5).getSunrise(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                .getDayOfWeek()
                .getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        state.setForecast7(LocalDateTime.parse(forecast.getWeathers().get(6).getSunrise(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                .getDayOfWeek()
                .getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        state.setForecast8(LocalDateTime.parse(forecast.getWeathers().get(7).getSunrise(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                .getDayOfWeek()
                .getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        state.setForecast9(LocalDateTime.parse(forecast.getWeathers().get(8).getSunrise(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                .getDayOfWeek()
                .getDisplayName(TextStyle.SHORT, Locale.ENGLISH));

        state.setForecast1Temp(forecast.getWeathers().get(0).getLowTemp().toString() + "° / " + forecast.getWeathers().get(0).getHighTemp().toString() + "°");
        state.setForecast2Temp(forecast.getWeathers().get(1).getLowTemp().toString() + "° / " + forecast.getWeathers().get(1).getHighTemp().toString() + "°");
        state.setForecast3Temp(forecast.getWeathers().get(2).getLowTemp().toString() + "° / " + forecast.getWeathers().get(2).getHighTemp().toString() + "°");
        state.setForecast4Temp(forecast.getWeathers().get(3).getLowTemp().toString() + "° / " + forecast.getWeathers().get(3).getHighTemp().toString() + "°");
        state.setForecast5Temp(forecast.getWeathers().get(4).getLowTemp().toString() + "° / " + forecast.getWeathers().get(4).getHighTemp().toString() + "°");
        state.setForecast6Temp(forecast.getWeathers().get(5).getLowTemp().toString() + "° / " + forecast.getWeathers().get(5).getHighTemp().toString() + "°");
        state.setForecast7Temp(forecast.getWeathers().get(6).getLowTemp().toString() + "° / " + forecast.getWeathers().get(6).getHighTemp().toString() + "°");
        state.setForecast8Temp(forecast.getWeathers().get(7).getLowTemp().toString() + "° / " + forecast.getWeathers().get(7).getHighTemp().toString() + "°");
        state.setForecast9Temp(forecast.getWeathers().get(8).getLowTemp().toString() + "° / " + forecast.getWeathers().get(8).getHighTemp().toString() + "°");

        try {
            state.setForecast1Icon(new ImageIcon(new ImageIcon("src/interface_adapter/icons/" + forecast.getWeathers().get(0).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast2Icon(new ImageIcon(new ImageIcon("src/interface_adapter/icons/" + forecast.getWeathers().get(1).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast3Icon(new ImageIcon(new ImageIcon("src/interface_adapter/icons/" + forecast.getWeathers().get(2).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast4Icon(new ImageIcon(new ImageIcon("src/interface_adapter/icons/" + forecast.getWeathers().get(3).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast5Icon(new ImageIcon(new ImageIcon("src/interface_adapter/icons/" + forecast.getWeathers().get(4).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast6Icon(new ImageIcon(new ImageIcon("src/interface_adapter/icons/" + forecast.getWeathers().get(5).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast7Icon(new ImageIcon(new ImageIcon("src/interface_adapter/icons/" + forecast.getWeathers().get(6).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast8Icon(new ImageIcon(new ImageIcon("src/interface_adapter/icons/" + forecast.getWeathers().get(7).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast9Icon(new ImageIcon(new ImageIcon("src/interface_adapter/icons/" + forecast.getWeathers().get(8).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not open icon file");
        }

    }

    @Override
    public void prepareForecast(ForecastOutputData forecast) {
        // TODO - implement
    }

    @Override
    public void prepareFailView(String error) {
        // TODO - implement
    }
}
