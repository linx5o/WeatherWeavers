package interface_adapter.GetWeatherOnMap;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeSupport;

public class GetWeatherOnMapViewModel extends ViewModel {
    // TODO
    private GetWeatherOnMapState state = new GetWeatherOnMapState();

    public GetWeatherOnMapViewModel() {
        super("map");
    }

    public void setState(GetWeatherOnMapState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("map", null, this.state);
    }

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public GetWeatherOnMapState getState() {
        return state;
    }
}
