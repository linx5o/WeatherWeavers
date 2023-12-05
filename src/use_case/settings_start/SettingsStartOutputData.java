package use_case.settings_start;

import java.util.ArrayList;

public class SettingsStartOutputData {
    private String defaultCity;
    private Boolean isCelsius;
    private Boolean isTime24;
    private ArrayList<String> cities;

    public SettingsStartOutputData(String defaultCity, Boolean isCelsius, Boolean isTime24, ArrayList<String> cities) {
        this.defaultCity = defaultCity;
        this.isCelsius = isCelsius;
        this.isTime24 = isTime24;
        this.cities = cities;
    }

    public String getDefaultCity() {
        return defaultCity;
    }

    public Boolean getCelsius() {
        return isCelsius;
    }

    public Boolean getTime24() {
        return isTime24;
    }

    public ArrayList<String> getCities() {
        return cities;
    }
}
