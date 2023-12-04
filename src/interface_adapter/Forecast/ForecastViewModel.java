package interface_adapter.Forecast;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ForecastViewModel extends ViewModel {

    private ForecastState state = new ForecastState();

    public ForecastViewModel() {
        super("forecast");
    }

    private final PropertyChangeSupport support =  new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void setState(ForecastState state) {
        this.state = state;
    }

    public ForecastState getState() {
        return state;
    }
}



