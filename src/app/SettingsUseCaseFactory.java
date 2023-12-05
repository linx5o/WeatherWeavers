package app;

import data_access.SettingsDataAccessObject;
import interface_adapter.Settings.SettingsViewModel;
import view.settings.SettingsView;

public class SettingsUseCaseFactory {
    private SettingsUseCaseFactory() {}

    public static SettingsView create(SettingsViewModel settingsViewModel, SettingsDataAccessObject settingsDataAccessObject) {
        try {
            return new SettingsView(settingsViewModel);
        } catch (Exception e) {
            // TODO - better error handling
        }

        return null;
    }
}
