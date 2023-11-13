package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HourlyViewModel extends ViewModel {
    public static final String HOURLY_LABEL = "Hourly";

    private HourlyState state = new HourlyState();

    public HourlyViewModel() {
        super(HOURLY_LABEL);
    }

    public void setState(HourlyState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange(HOURLY_LABEL, null, this.state);
    }

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public HourlyState getState() {
        return state;
    }
}
