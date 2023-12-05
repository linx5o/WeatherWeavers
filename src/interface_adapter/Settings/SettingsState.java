package interface_adapter.Settings;

import java.util.ArrayList;

public class SettingsState {
    private ArrayList<String> cityList = new ArrayList<>();
    private String listCityMessage = "";
    private boolean tempUnit = true;
    private boolean is24HourFormat = true;
    private String listCityCity = "";
    private String listCityCountry = "";
    private String defaultCityMessage = "";
    private String defaultCity = "";
    private String defaultCityCity = "";
    private String defaultCityCountry = "";
    private String eraseCityMessage = "";
    private String eraseCityCity = "";
    private String eraseCityCountry = "";

    public SettingsState() {
    }

    public String getListCityCity() {
        return listCityCity;
    }

    public void setListCityCity(String listCityCity) {
        this.listCityCity = listCityCity;
    }

    public String getListCityCountry() {
        return listCityCountry;
    }

    public void setListCityCountry(String listCityCountry) {
        this.listCityCountry = listCityCountry;
    }

    public String getDefaultCityMessage() {
        return defaultCityMessage;
    }

    public void setDefaultCityMessage(String defaultCityMessage) {
        this.defaultCityMessage = defaultCityMessage;
    }

    public String getDefaultCity() {
        return defaultCity;
    }

    public void setDefaultCity(String defaultCity) {
        this.defaultCity = defaultCity;
    }

    public String getDefaultCityCity() {
        return defaultCityCity;
    }

    public void setDefaultCityCity(String defaultCityCity) {
        this.defaultCityCity = defaultCityCity;
    }

    public String getDefaultCityCountry() {
        return defaultCityCountry;
    }

    public void setDefaultCityCountry(String defaultCityCountry) {
        this.defaultCityCountry = defaultCityCountry;
    }

    public void addListCity(ArrayList<String> city) {
        this.cityList = city;
    }

    public ArrayList<String> getCityList() {
        ArrayList<String> cityListFormatted = new ArrayList<>();
        for (String city : cityList) {
            String[] citySplit = city.split(",");
            cityListFormatted.add(citySplit[0].substring(0, 1).toUpperCase() + citySplit[0].substring(1) + ", " + citySplit[1].toUpperCase());
        }
        return cityListFormatted;
    }

    public void setListCityMessage(String message) {
        this.listCityMessage = message;
    }

    public String getListCityMessage() {
        return listCityMessage;
    }

    public boolean getTempUnit() {
        return tempUnit;
    }

    public boolean getIs24HourFormat() {
        return is24HourFormat;
    }

    public void setTempUnit(boolean tempUnit) {
        this.tempUnit = tempUnit;
    }

    public void setTimeFormat(boolean is24HourFormat) {
        this.is24HourFormat = is24HourFormat;
    }

    public String getEraseCityMessage() {
        return eraseCityMessage;
    }

    public void setEraseCityMessage(String eraseCityMessage) {
        this.eraseCityMessage = eraseCityMessage;
    }

    public String getEraseCityCity() {
        return eraseCityCity;
    }

    public void setEraseCityCity(String eraseCityCity) {
        this.eraseCityCity = eraseCityCity;
    }

    public String getEraseCityCountry() {
        return eraseCityCountry;
    }

    public void setEraseCityCountry(String eraseCityCountry) {
        this.eraseCityCountry = eraseCityCountry;
    }
}
