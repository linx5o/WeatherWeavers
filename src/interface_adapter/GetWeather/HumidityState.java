package interface_adapter.GetWeather;


public class HumidityState {
    private int humidityPercentage;

    // Default constructor
    public HumidityState() {
        // Initialize with a default value if necessary
        this.humidityPercentage = 0; // Default humidity percentage
    }

    // Getter and Setter
    public int getHumidityPercentage() {
        return humidityPercentage;
    }

    public void setHumidityPercentage(int humidityPercentage) {
        this.humidityPercentage = humidityPercentage;
    }

}

