package entity;

public class Humidity {
    private String descriptions;
    private double humidity;

    public Humidity(double humidity, String descriptions) {
        this.descriptions = descriptions;
        this.humidity = humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getHumidity() {
        return this.humidity;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getDescriptions() {
        return descriptions;
    }
}



