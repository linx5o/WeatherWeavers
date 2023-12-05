package interface_adapter.Settings;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SettingsViewModel extends ViewModel{
    public static final String SET_DEFAULT_CITY_BUTTON_LABEL = "Set Default City";
    public static final String SET_CITY_BUTTON_LABEL = "Add City";
    public static final String ERASE_CITY_BUTTON_LABEL = "Remove City";

    private SettingsState state = new SettingsState();

    public SettingsViewModel() {
        super("settings");
    }

    public void setState(SettingsState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("settings", null, this.state);
    }

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public SettingsState getState() {
        return state;
    }
}
