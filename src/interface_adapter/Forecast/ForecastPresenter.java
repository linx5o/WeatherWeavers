package interface_adapter.Forecast;

import interface_adapter.ViewManagerModel;
import use_case.forecast.ForecastOutputBoundary;
import use_case.forecast.ForecastOutputData;

import javax.swing.*;

public class  ForecastPresenter implements ForecastOutputBoundary {
    private final ForecastViewModel forcastViewModel;

    public ForecastPresenter(ForecastViewModel forecastViewModel) {
        this.forcastViewModel = forecastViewModel;
    }

    @Override
    public void prepareInformationForecast(ForecastOutputData forecast) {
        ForecastState state = forcastViewModel.getState();

        state.setForecast1(forecast.getWeathers().get(0).getWeekDay());
        state.setForecast2(forecast.getWeathers().get(1).getWeekDay());
        state.setForecast3(forecast.getWeathers().get(2).getWeekDay());
        state.setForecast4(forecast.getWeathers().get(3).getWeekDay());
        state.setForecast5(forecast.getWeathers().get(4).getWeekDay());
        state.setForecast6(forecast.getWeathers().get(5).getWeekDay());
        state.setForecast7(forecast.getWeathers().get(6).getWeekDay());
        state.setForecast8(forecast.getWeathers().get(7).getWeekDay());
        state.setForecast9(forecast.getWeathers().get(8).getWeekDay());

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
            state.setForecast1Icon(new ImageIcon(new ImageIcon("src/interface_adapter/Forecast/icons/" + forecast.getWeathers().get(0).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast2Icon(new ImageIcon(new ImageIcon("src/interface_adapter/Forecast/icons/" + forecast.getWeathers().get(1).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast3Icon(new ImageIcon(new ImageIcon("src/interface_adapter/Forecast/icons/" + forecast.getWeathers().get(2).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast4Icon(new ImageIcon(new ImageIcon("src/interface_adapter/Forecast/icons/" + forecast.getWeathers().get(3).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast5Icon(new ImageIcon(new ImageIcon("src/interface_adapter/Forecast/icons/" + forecast.getWeathers().get(4).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast6Icon(new ImageIcon(new ImageIcon("src/interface_adapter/Forecast/icons/" + forecast.getWeathers().get(5).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast7Icon(new ImageIcon(new ImageIcon("src/interface_adapter/Forecast/icons/" + forecast.getWeathers().get(6).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast8Icon(new ImageIcon(new ImageIcon("src/interface_adapter/Forecast/icons/" + forecast.getWeathers().get(7).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            state.setForecast9Icon(new ImageIcon(new ImageIcon("src/interface_adapter/Forecast/icons/" + forecast.getWeathers().get(8).getDescriptions().split(";")[1]).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
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
