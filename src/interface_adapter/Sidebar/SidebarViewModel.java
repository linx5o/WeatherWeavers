package interface_adapter.Sidebar;

import interface_adapter.ViewModel;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SidebarViewModel extends ViewModel {
    public static final ImageIcon ICON = new ImageIcon("src/interface_adapter/sidebar/sidebar.png");
    public static final ImageIcon WEATHER_ICON = new ImageIcon("src/interface_adapter/sidebar/weather.png");
    public static final String WEATHER_LABEL = "Weather";
    public static final ImageIcon CITIES_ICON = new ImageIcon("src/interface_adapter/sidebar/cities.png");
    public static final String CITIES_LABEL = "Cities";
    public static final ImageIcon MAP_ICON = new ImageIcon("src/interface_adapter/sidebar/map.png");
    public static final String MAP_LABEL = "Map";
    public static final ImageIcon SETTINGS_ICON = new ImageIcon("src/interface_adapter/sidebar/settings.png");
    public static final String SETTINGS_LABEL = "Settings";

    private SidebarState state = new SidebarState();

    public SidebarViewModel() {
        super("sidebar");
    }

    public void setState(SidebarState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("sidebar", null, this.state);
    }

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SidebarState getState() {
        return state;
    }
}
