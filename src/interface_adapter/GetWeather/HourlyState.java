package interface_adapter.GetWeather;


public class HourlyState {
    // Assuming each hourly state has a forecast text and temperature, but it can be any data relevant to your application
    private String forecastText;
    private double temperature;

    // Default constructor
    public HourlyState() {
        // Initialize with default values or with values fetched from a service
        this.forecastText = "Sunny"; // Default forecast text
        this.temperature = 20.0;     // Default temperature
    }

    // Constructor with parameters if needed to set initial state
    public HourlyState(String forecastText, double temperature) {
        this.forecastText = forecastText;
        this.temperature = temperature;
    }

    // Getters and setters
    public String getForecastText() {
        return forecastText;
    }

    public void setForecastText(String forecastText) {
        this.forecastText = forecastText;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    // You might also include other relevant state data and methods for the hourly forecast
}
