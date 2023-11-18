package interface_adapter.Settings;

public class SettingsState {
    private boolean darkModeEnabled;
    private String preferredLanguage;
    private TemperatureUnit temperatureUnit;

    // Default constructor
    public SettingsState() {
        // Initialize with default settings
        this.darkModeEnabled = false; // Default to light mode
        this.preferredLanguage = "English"; // Default language
        this.temperatureUnit = TemperatureUnit.CELSIUS; // Default temperature unit
    }

    // Getters and Setters
    public boolean isDarkModeEnabled() {
        return darkModeEnabled;
    }

    public void setDarkModeEnabled(boolean darkModeEnabled) {
        this.darkModeEnabled = darkModeEnabled;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public TemperatureUnit getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(TemperatureUnit temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

}

enum TemperatureUnit {
    CELSIUS, FAHRENHEIT;
}
