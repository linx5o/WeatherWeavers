package interface_adapter;

import javax.swing.text.View;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OtherCitiesViewModel extends ViewModel {
    public static final String OTHER_CITIES_LABEL = "Other Cities";
    public static final String VIEW_MAP_BUTTON_LABEL = "View Map";

    private OtherCitiesState state = new OtherCitiesState();

    public OtherCitiesViewModel() {
        super("otherCities");
    }

    public void setState(OtherCitiesState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange(OTHER_CITIES_LABEL, null, this.state);
    }

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public OtherCitiesState getState() {
        return state;
    }
}
