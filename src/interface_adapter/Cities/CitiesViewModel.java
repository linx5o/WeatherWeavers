package interface_adapter.Cities;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CitiesViewModel extends ViewModel {
    // TODO

    private CitiesState state = new CitiesState();

    public CitiesViewModel() {
        super("cities");
    }

    public void setState(CitiesState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("cities", null, this.state);
    }

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public CitiesState getState() {
        return state;
    }
}
