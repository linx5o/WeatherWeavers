package interface_adapter.Sidebar;

public class SidebarState {
    private boolean weatherSelected;
    private boolean citiesSelected;
    private boolean mapSelected;
    private boolean settingsSelected;

    public SidebarState() {
        this.weatherSelected = false;
        this.citiesSelected = false;
        this.mapSelected = false;
        this.settingsSelected = false;
    }

    public boolean isWeatherSelected() {
        return weatherSelected;
    }

    public void setWeatherSelected(boolean weatherSelected) {
        this.weatherSelected = weatherSelected;
    }

    public boolean isCitiesSelected() {
        return citiesSelected;
    }

    public void setCitiesSelected(boolean citiesSelected) {
        this.citiesSelected = citiesSelected;
    }

    public boolean isMapSelected() {
        return mapSelected;
    }

    public void setMapSelected(boolean mapSelected) {
        this.mapSelected = mapSelected;
    }

    public boolean isSettingsSelected() {
        return settingsSelected;
    }

    public void setSettingsSelected(boolean settingsSelected) {
        this.settingsSelected = settingsSelected;
    }

}
