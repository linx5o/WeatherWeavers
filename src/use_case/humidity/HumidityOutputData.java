package use_case.humidity;

import entity.Humidity;

public class HumidityOutputData {
    private final Double humidity;
    private final String descriptions;

    public HumidityOutputData(Humidity humidity) {
        this.humidity = humidity.getHumidity();
        this.descriptions = humidity.getDescriptions();
    }

    public Double getHumidity() {
        return humidity;
    }

    public String getDescriptions() {
        return descriptions;
    }
}
