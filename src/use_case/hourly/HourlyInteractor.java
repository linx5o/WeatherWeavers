package use_case.hourly;

import java.time.LocalTime;
import java.util.ArrayList;

public class HourlyInteractor implements HourlyInputBoundary{

        final HourlyOutputBoundary hourlyPresenter;
        final HourlyDataAccessInterface hourlyDataAccessObject;
        final HourlySettingsDataAccessInterface hourlySettingsDataAccessObject;

        public HourlyInteractor(HourlyOutputBoundary hourlyOutputBoundary, HourlyDataAccessInterface hourlyDataAccessObject, HourlySettingsDataAccessInterface hourlySettingsDataAccessObject) {
            this.hourlyPresenter = hourlyOutputBoundary;
            this.hourlyDataAccessObject = hourlyDataAccessObject;
            this.hourlySettingsDataAccessObject = hourlySettingsDataAccessObject;
        }

        @Override
        public void execute(HourlyInputData hourlyInputData) {
            try {
                Boolean celsius = hourlySettingsDataAccessObject.getSettings().getCelsius();
                Boolean timeFormat = hourlySettingsDataAccessObject.getSettings().getTimeFormat();
                ArrayList<LocalTime> hours = hourlyDataAccessObject.getHours(hourlyInputData.getCity(), hourlyInputData.getTime());
                ArrayList<Integer> temps = hourlyDataAccessObject.getTemps(hourlyInputData.getCity(), hourlyInputData.getTime(), celsius);
                HourlyOutputData hourlyOutputData = new HourlyOutputData(hours, temps, timeFormat);
                hourlyPresenter.prepareSuccessView(hourlyOutputData);
            } catch (Exception e) {
                hourlyPresenter.prepareFailView("Error");
            }
        }

    @Override
    public void execute(LocalTime localTime) {
        try {
            Boolean celsius = hourlySettingsDataAccessObject.getSettings().getCelsius();
            Boolean timeFormat = hourlySettingsDataAccessObject.getSettings().getTimeFormat();
            ArrayList<LocalTime> hours = hourlyDataAccessObject.getHours(hourlySettingsDataAccessObject.getSettings().getDefaultCity(), localTime);
            ArrayList<Integer> temps = hourlyDataAccessObject.getTemps(hourlySettingsDataAccessObject.getSettings().getDefaultCity(), localTime, celsius);
            HourlyOutputData hourlyOutputData = new HourlyOutputData(hours, temps, timeFormat);
            hourlyPresenter.prepareSuccessView(hourlyOutputData);
        } catch (Exception e) {
            hourlyPresenter.prepareFailView("Error");
        }
    }
}
