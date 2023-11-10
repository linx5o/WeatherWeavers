package entity;

public class Weather {
    private String descriptions;

    private Temperature temperature;
    private Location location;
    private Humidity humidity;

    public Weather(String descriptions, Temperature temperature, Location location, Humidity humidity) {
        this.descriptions = descriptions;
        this.temperature = temperature;
        this.location = location;
        this.humidity = humidity;
    }

    public Humidity getHumidity() {
        return humidity;
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

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
