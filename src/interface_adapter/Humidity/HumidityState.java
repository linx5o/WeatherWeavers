package interface_adapter.Humidity;

public class HumidityState {
    private String humidity = null;
    private String descriptions = null;

    public HumidityState() {}

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

}
