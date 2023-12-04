package interface_adapter.Settings;

import java.util.ArrayList;

public class SettingsState {
    private ArrayList<String> cityList;
    private String listCityMessage;
    private boolean tempUnit;
    private boolean is24HourFormat;

    public SettingsState() {
    }

    public void addListCity(String city) {
        this.cityList.add(city);
    }

    public ArrayList<String> getCityList() {
        return cityList;
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
}
