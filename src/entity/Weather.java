package entity;

public class Weather {
    private final String descriptions;

    private final Temperature temperature;
    private final Location location;
    private final Boolean celcius;

    public Weather(String descriptions, Temperature temperature, Location location, Boolean celcius) {
        this.descriptions = descriptions;
        this.temperature = temperature;
        this.location = location;
        this.celcius = celcius;

    }

    public Boolean getCelcius() {
        return celcius;
    }

    public Location getLocation() {
        return location;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public Temperature getTemperature() {
        return temperature;
    }
}
