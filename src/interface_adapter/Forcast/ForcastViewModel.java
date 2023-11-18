package interface_adapter.Forcast;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ForcastViewModel extends ViewModel {

    private ForcastState state = new ForcastState();

    public ForcastViewModel(String viewName) {
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

    public void setState(ForcastState state) {
        this.state = state;
    }

    public ForcastState getState() {
        return state;
    }
}
