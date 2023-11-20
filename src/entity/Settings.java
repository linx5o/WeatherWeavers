package entity;

import java.util.ArrayList;

public class Settings {

    private Boolean celsius;
    private Boolean darkMode; // True for dark mode, False for light mode
    private Boolean timeFormat; // True for 24-hour format, False for 12-hour format
    private String defaultCity;
    private ArrayList<String> savedCities;

    public Settings(Boolean celsius, Boolean darkMode, Boolean timeFormat, String defaultCity, ArrayList<String> savedCities) {
        this.celsius = celsius;
        this.darkMode = darkMode;
        this.timeFormat = timeFormat;
        this.defaultCity = defaultCity;
        this.savedCities = savedCities;
    }

    public Boolean getCelsius() {
        return this.celsius;
    }

    public Boolean getDarkMode() {
        return this.darkMode;
    }

    public Boolean getTimeFormat() {
        return this.timeFormat;
    }

    public String getDefaultCity() {
        return this.defaultCity;
    }

    public ArrayList<String> getSavedCities() {
        return this.savedCities;
    }

    public void setCelsius(Boolean celsius) {
        this.celsius = celsius;
    }

    public void setDarkMode(Boolean DarkMode) {
        this.darkMode = DarkMode;
    }

    public void setTimeFormat(Boolean TimeFormat) {
        this.timeFormat = TimeFormat;
    }

    public void setDefaultCity(String defaultCity) {
        this.defaultCity = defaultCity;
    }

    public void addSavedCities(String savedCities) {
        this.savedCities.add(savedCities);
    }

    public void removeSavedCities(String savedCities) {
        this.savedCities.remove(savedCities);
    }

    public void emptySavedCities() {
        this.savedCities = new ArrayList<String>();
    }

}
