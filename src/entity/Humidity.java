package entity;

public class Humidity {
    private String descriptions;
    private Integer humidity;

    public Humidity(Integer humidity) {
        this.humidity = humidity;
        setDescriptions();
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
        setDescriptions();
    }

    public Integer getHumidity() {
        return this.humidity;
    }

    public void setDescriptions() {
        if (this.humidity <= 20) {
            this.descriptions = "Very Low";
        } else if (this.humidity <= 30) {
            this.descriptions = "Low";
        } else if (this.humidity <= 40) {
            this.descriptions = "Moderately Low";
        } else if (this.humidity <= 50) {
            this.descriptions = "Comfortable";
        } else if (this.humidity <= 60) {
            this.descriptions = "Moderately High";
        } else if (this.humidity <= 70) {
            this.descriptions = "High";
        } else if (this.humidity <= 80) {
            this.descriptions = "Very High";
        } else if (this.humidity <= 90) {
            this.descriptions = "Extremely High";
        } else {
            this.descriptions = "Saturated";
        }
    }

    public String getDescriptions() {
        return descriptions;
    }
}



