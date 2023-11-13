package interface_adapter.GetWeather;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GetWeatherViewModel extends ViewModel {
    // TODO

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
