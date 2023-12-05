package view.settings;

import interface_adapter.EraseCity.EraseCityController;
import interface_adapter.SetCity.SetCityController;
import interface_adapter.SetDefaultCity.SetDefaultCityController;
import interface_adapter.SetTempUnit.SetTempUnitController;
import interface_adapter.SetTimeFormat.SetTimeFormatController;
import interface_adapter.Settings.SettingsViewModel;
import interface_adapter.SettingsStart.SettingsStartController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SettingsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "settings";
    public SettingsView(SettingsViewModel settingsViewModel, SettingsStartController settingsController, EraseCityController eraseCityController, SetCityController setCityController, SetDefaultCityController setDefaultCityController, SetTempUnitController setTempUnitController, SetTimeFormatController setTimeFormatController) {


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
