package view.settings;

import interface_adapter.EraseCity.EraseCityController;
import interface_adapter.SetCity.SetCityController;
import interface_adapter.SetDefaultCity.SetDefaultCityController;
import interface_adapter.SetTempUnit.SetTempUnitController;
import interface_adapter.SetTimeFormat.SetTimeFormatController;
import interface_adapter.Settings.SettingsViewModel;
import interface_adapter.SettingsStart.SettingsStartController;
import view.ToggleSwitch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SettingsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "settings";

    private final JTextField defaultCityCityInputField = new JTextField(15);
    private final JTextField defaultCityCountryInputField = new JTextField(15);
    private final JTextField cityCityInputField = new JTextField(15);
    private final JTextField cityCountryInputField = new JTextField(15);
    private final JTextField eraseCityCityInputField = new JTextField(15);
    private final JTextField eraseCityCountryInputField = new JTextField(15);
    private final JButton setDefaultCityButton;
    private final JButton setCityButton;
    private final JButton eraseCityButton;
    private final ToggleSwitch tempUnitToggleSwitch;
    private final ToggleSwitch timeFormatToggleSwitch;
    private final SettingsViewModel settingsViewModel;
    private final SettingsStartController settingsController;
    private final EraseCityController eraseCityController;
    private final SetCityController setCityController;
    private final SetDefaultCityController setDefaultCityController;
    private final SetTempUnitController setTempUnitController;
    private final SetTimeFormatController setTimeFormatController;


    public SettingsView(SettingsViewModel settingsViewModel, SettingsStartController settingsController, EraseCityController eraseCityController, SetCityController setCityController, SetDefaultCityController setDefaultCityController, SetTempUnitController setTempUnitController, SetTimeFormatController setTimeFormatController) {
        this.settingsViewModel = settingsViewModel;
        this.settingsController = settingsController;
        this.eraseCityController = eraseCityController;
        this.setCityController = setCityController;
        this.setDefaultCityController = setDefaultCityController;
        this.setTempUnitController = setTempUnitController;
        this.setTimeFormatController = setTimeFormatController;

        this.setDefaultCityButton = new JButton(settingsViewModel.SET_DEFAULT_CITY_BUTTON_LABEL);
        this.setCityButton = new JButton(settingsViewModel.SET_CITY_BUTTON_LABEL);
        this.eraseCityButton = new JButton(settingsViewModel.ERASE_CITY_BUTTON_LABEL);
        this.tempUnitToggleSwitch = new ToggleSwitch();
        this.timeFormatToggleSwitch = new ToggleSwitch();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
