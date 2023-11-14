package interface_adapter.GetWeather;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GetWeatherViewModel extends ViewModel {
    public static final String HIGH_LABEL = "High";
    public static final String LOW_LABEL = "Low";
    public static final String WIND_LABEL = "Wind";
    public static final String RAIN_LABEL = "Rain";
    public static final String SUNRISE_LABEL = "Sunrise";
    public static final String SUNSET_LABEL = "Sunset";

    private GetWeatherState state = new GetWeatherState();

    public GetWeatherViewModel() {
        super("get weather");
    }

    public void setState(GetWeatherState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("get weather", null, this.state);
    }

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public GetWeatherState getState() {
        return state;
    }
}
