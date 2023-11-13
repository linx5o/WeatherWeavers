package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MapViewModel extends ViewModel {
    // TODO
    private MapState state = new MapState();

    public MapViewModel() {
        super("map");
    }

    public void setState(MapState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("map", null, this.state);
    }

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public MapState getState() {
        return state;
    }
}
