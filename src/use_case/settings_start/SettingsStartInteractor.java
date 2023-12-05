package use_case.settings_start;


import entity.Settings;

public class SettingsStartInteractor implements SettingsStartInputBoundary {
    private SettingsStartOutputBoundary presenter;
    private SettingsDataAccessInterface settingsDataAccessObject;

    public SettingsStartInteractor(SettingsStartOutputBoundary presenter, SettingsDataAccessInterface settingsDataAccessObject) {
        this.presenter = presenter;
        this.settingsDataAccessObject = settingsDataAccessObject;
    }

    @Override
    public void execute() {
        Settings settings = settingsDataAccessObject.getSettings();
        SettingsStartOutputData outputData = new SettingsStartOutputData(settings.getDefaultCity(), settings.getCelsius(), settings.getTimeFormat(), settings.getSavedCities());
        presenter.prepareSuccessView(outputData);
    }
}
