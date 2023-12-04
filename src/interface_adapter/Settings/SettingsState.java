package interface_adapter.Settings;

public class SettingsState {
    private String city;
    private boolean tempUnit;
    private boolean is24HourFormat;

    public SettingsState() {
    }

    public String getCity() {
        return city;
    }

    public boolean getTempUnit() {
        return tempUnit;
    }

    public boolean getIs24HourFormat() {
        return is24HourFormat;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTempUnit(boolean tempUnit) {
        this.tempUnit = tempUnit;
    }

    public void setTimeFormat(boolean is24HourFormat) {
        this.is24HourFormat = is24HourFormat;
    }
}
