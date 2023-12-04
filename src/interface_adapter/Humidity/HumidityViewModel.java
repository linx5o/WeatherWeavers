package interface_adapter.Humidity;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeSupport;

public class HumidityViewModel extends ViewModel{
    public static final String HUMIDITY_LABEL = "Humidity";

    private HumidityState state = new HumidityState();

    public HumidityViewModel() {
        super("humidity");
    }

    public void setState(HumidityState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("humidity", null, this.state);
    }

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public HumidityState getState() {
        return state;
    }
}
