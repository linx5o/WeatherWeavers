package entity;

public class TemperatureUnit {
    public enum Unit {
        CELSIUS, FAHRENHEIT
    }

    private Unit currentUnit;

    public TemperatureUnit(Unit defaultUnit) {
        this.currentUnit = defaultUnit;
    }

    public Unit getCurrentUnit() {
        return currentUnit;
    }

    public void setCurrentUnit(Unit currentUnit) {
        this.currentUnit = currentUnit;
    }
}

