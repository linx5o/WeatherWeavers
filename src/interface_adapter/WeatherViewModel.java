package interface_adapter;

import java.beans.PropertyChangeListener;

public class WeatherViewModel extends ViewModel {
    public WeatherViewModel() {
        super("weather");
    }
    @Override
    public void firePropertyChanged() {
        // TODO: Implement this method
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        // TODo: Implement this method
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        // TODO: Implement this method
    }
}
