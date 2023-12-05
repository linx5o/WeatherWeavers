package interface_adapter.Hourly;

import interface_adapter.Hourly.HourlyState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HourlyViewModel extends ViewModel {
    public static final String HOURLY_LABEL = "Hourly";

    private HourlyState state = new HourlyState();

    public HourlyViewModel() {
        super("hourly");
    }

    public void setState(HourlyState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("hourly", null, this.state);
    }

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public HourlyState getState() {
        return state;
    }
}
