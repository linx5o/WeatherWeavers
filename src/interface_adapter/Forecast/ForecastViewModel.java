package interface_adapter.Forecast;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ForecastViewModel extends ViewModel {

    private ForecastState state = new ForecastState();

    public ForecastViewModel(String viewName) {
        super(viewName);
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

    public void setState(ForecastState state) {
        this.state = state;
    }

    public ForecastState getState() {
        return state;
    }
}
