package app;

import data_access.SettingsDataAccessObject;
import interface_adapter.EraseCity.EraseCityController;
import interface_adapter.EraseCity.EraseCityPresenter;
import interface_adapter.SetCity.SetCityController;
import interface_adapter.SetCity.SetCityPresenter;
import interface_adapter.SetDefaultCity.SetDefaultCityController;
import interface_adapter.SetDefaultCity.SetDefaultCityPresenter;
import interface_adapter.SetTempUnit.SetTempUnitController;
import interface_adapter.SetTempUnit.SetTempUnitPresenter;
import interface_adapter.SetTimeFormat.SetTimeFormatController;
import interface_adapter.SetTimeFormat.SetTimeFormatPresenter;
import interface_adapter.Settings.SettingsViewModel;
import interface_adapter.SettingsStart.SettingsStartController;
import interface_adapter.SettingsStart.SettingsStartPresenter;
import use_case.erase_city.EraseCityDataAccessInterface;
import use_case.erase_city.EraseCityInputBoundary;
import use_case.erase_city.EraseCityInteractor;
import use_case.erase_city.EraseCityOutputBoundary;
import use_case.set_city.SetCityDataAccessInterface;
import use_case.set_city.SetCityInputBoundary;
import use_case.set_city.SetCityInteractor;
import use_case.set_city.SetCityOutputBoundary;
import use_case.set_default_city.SetDefaultCityDataAccessInterface;
import use_case.set_default_city.SetDefaultCityInputBoundary;
import use_case.set_default_city.SetDefaultCityInteractor;
import use_case.set_default_city.SetDefaultCityOutputBoundary;
import use_case.set_temp_unit.SetTempUnitDataAccessInterface;
import use_case.set_temp_unit.SetTempUnitInputBoundary;
import use_case.set_temp_unit.SetTempUnitInteractor;
import use_case.set_temp_unit.SetTempUnitOutputBoundary;
import use_case.set_time_format.SetTimeFormatDataAccessInterface;
import use_case.set_time_format.SetTimeFormatInputBoundary;
import use_case.set_time_format.SetTimeFormatInteractor;
import use_case.set_time_format.SetTimeFormatOutputBoundary;
import use_case.settings_start.SettingsDataAccessInterface;
import use_case.settings_start.SettingsStartInputBoundary;
import use_case.settings_start.SettingsStartInteractor;
import use_case.settings_start.SettingsStartOutputBoundary;
import view.settings.SettingsView;

public class SettingsUseCaseFactory {
    private SettingsUseCaseFactory() {}

    public static SettingsView create(SettingsViewModel settingsViewModel, SettingsDataAccessInterface settingsDataAccessObject, EraseCityDataAccessInterface eraseCityDataAccessObject, SetCityDataAccessInterface setCityDataAccessObject, SetDefaultCityDataAccessInterface setDefaultCityDataAccessObject, SetTempUnitDataAccessInterface setTempUnitDataAccessObject, SetTimeFormatDataAccessInterface setTimeFormatDataAccessObject) {
        try {
            SettingsStartController settingsStartController = createSettingsStartUseCase(settingsViewModel, settingsDataAccessObject);
            EraseCityController eraseCityController = createEraseCityUseCase(settingsViewModel, eraseCityDataAccessObject);
            SetCityController setCityController = createSetCityUseCase(settingsViewModel, setCityDataAccessObject);
            SetDefaultCityController setDefaultCityController = createSetDefaultCityUseCase(settingsViewModel, setDefaultCityDataAccessObject);
            SetTempUnitController setTempUnitController = createSetTempUnitUseCase(settingsViewModel, setTempUnitDataAccessObject);
            SetTimeFormatController setTimeFormatController = createSetTimeFormatUseCase(settingsViewModel, setTimeFormatDataAccessObject);

            return new SettingsView(settingsViewModel, settingsStartController, eraseCityController, setCityController, setDefaultCityController, setTempUnitController, setTimeFormatController);
        } catch (Exception e) {
            System.err.println("An error occurred while creating the SettingsUseCaseFactory: " + e.getMessage());
        }

        return null;
    }

    private static SettingsStartController createSettingsStartUseCase(SettingsViewModel settingsViewModel, SettingsDataAccessInterface settingsDataAccessObject) {
        SettingsStartOutputBoundary settingsStartOutputBoundary = new SettingsStartPresenter(settingsViewModel);
        SettingsStartInputBoundary settingsStartInteractor = new SettingsStartInteractor(settingsStartOutputBoundary, settingsDataAccessObject);
        return new SettingsStartController(settingsStartInteractor);
    }

    private static EraseCityController createEraseCityUseCase(SettingsViewModel settingsViewModel, EraseCityDataAccessInterface eraseCityDataAccessObject) {
        EraseCityOutputBoundary eraseCityOutputBoundary = new EraseCityPresenter(settingsViewModel);
        EraseCityInputBoundary eraseCityInteractor = new EraseCityInteractor(eraseCityOutputBoundary, eraseCityDataAccessObject);
        return new EraseCityController(eraseCityInteractor);
    }

    private static SetCityController createSetCityUseCase(SettingsViewModel settingsViewModel, SetCityDataAccessInterface setCityDataAccessObject) {
        SetCityOutputBoundary setCityOutputBoundary = new SetCityPresenter(settingsViewModel);
        SetCityInputBoundary setCityInteractor = new SetCityInteractor(setCityOutputBoundary, setCityDataAccessObject);
        return new SetCityController(setCityInteractor);
    }

    private static SetDefaultCityController createSetDefaultCityUseCase(SettingsViewModel settingsViewModel, SetDefaultCityDataAccessInterface setDefaultCityDataAccessObject) {
        SetDefaultCityOutputBoundary setDefaultCityOutputBoundary = new SetDefaultCityPresenter(settingsViewModel);
        SetDefaultCityInputBoundary setDefaultCityInteractor = new SetDefaultCityInteractor(setDefaultCityOutputBoundary, setDefaultCityDataAccessObject);
        return new SetDefaultCityController(setDefaultCityInteractor);
    }

    private static SetTempUnitController createSetTempUnitUseCase(SettingsViewModel settingsViewModel, SetTempUnitDataAccessInterface setTempUnitDataAccessObject) {
        SetTempUnitOutputBoundary setTempUnitOutputBoundary = new SetTempUnitPresenter(settingsViewModel);
        SetTempUnitInputBoundary setTempUnitInteractor = new SetTempUnitInteractor(setTempUnitOutputBoundary, setTempUnitDataAccessObject);
        return new SetTempUnitController(setTempUnitInteractor);
    }

    private static SetTimeFormatController createSetTimeFormatUseCase(SettingsViewModel settingsViewModel, SetTimeFormatDataAccessInterface setTimeFormatDataAccessObject) {
        SetTimeFormatOutputBoundary setTimeFormatOutputBoundary = new SetTimeFormatPresenter(settingsViewModel);
        SetTimeFormatInputBoundary setTimeFormatInteractor = new SetTimeFormatInteractor(setTimeFormatDataAccessObject, setTimeFormatOutputBoundary);
        return new SetTimeFormatController(setTimeFormatInteractor);
    }
}
