package interface_adapter.SettingsStart;

import use_case.settings_start.SettingsStartInputBoundary;

public class SettingsStartController {
    final SettingsStartInputBoundary settingsStartUseCaseInteractor;

    public SettingsStartController(SettingsStartInputBoundary settingsStartUseCaseInteractor) {
        this.settingsStartUseCaseInteractor = settingsStartUseCaseInteractor;
    }

    public void execute() {
        settingsStartUseCaseInteractor.execute();
    }
}
