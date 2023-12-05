package view.settings;

import interface_adapter.EraseCity.EraseCityController;
import interface_adapter.SetCity.SetCityController;
import interface_adapter.SetDefaultCity.SetDefaultCityController;
import interface_adapter.SetTempUnit.SetTempUnitController;
import interface_adapter.SetTimeFormat.SetTimeFormatController;
import interface_adapter.Settings.SettingsState;
import interface_adapter.Settings.SettingsViewModel;
import interface_adapter.SettingsStart.SettingsStartController;
import view.RoundedPanel;
import view.ToggleSwitch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class SettingsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "settings";

    private final JLabel defaultCityMessage = new JLabel();
    private final JLabel cityMessage = new JLabel();
    private final JLabel eraseCityMessage = new JLabel();
    private final JList<String> cityList = new JList<>();
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
        this.cityList.setVisibleRowCount(6);

        JScrollPane scrollPane = new JScrollPane(this.cityList);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(920, 620));
        this.setBackground(Color.decode("#0D131D"));

        this.addPropertyChangeListener(this);

        settingsController.execute();

        RoundedPanel defaultCityPanel = new RoundedPanel(40);
        RoundedPanel togglesPanel = new RoundedPanel(40);
        RoundedPanel cityListPanel = new RoundedPanel(40);

        defaultCityPanel.setLayout(new GridBagLayout());
        defaultCityPanel.setPreferredSize(new Dimension(520, 180));
        defaultCityPanel.setBackground(Color.decode("#222B3A"));

        togglesPanel.setLayout(new GridBagLayout());
        togglesPanel.setPreferredSize(new Dimension(360, 180));
        togglesPanel.setBackground(Color.decode("#222B3A"));

        cityListPanel.setLayout(new GridBagLayout());
        cityListPanel.setPreferredSize(new Dimension(900, 380));
        cityListPanel.setBackground(Color.decode("#222B3A"));

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 0, 0);

        this.add(defaultCityPanel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 20, 0, 20);

        this.add(togglesPanel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(20, 0, 40, 20);

        this.add(cityListPanel, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SettingsState currentState = settingsViewModel.getState();
        this.defaultCityCityInputField.setText(currentState.getDefaultCityCity());
        this.defaultCityCountryInputField.setText(currentState.getDefaultCityCountry());
        this.cityCityInputField.setText(currentState.getListCityCity());
        this.cityCountryInputField.setText(currentState.getListCityCountry());
        this.eraseCityCityInputField.setText(currentState.getEraseCityCity());
        this.eraseCityCountryInputField.setText(currentState.getEraseCityCountry());
        this.defaultCityMessage.setText(currentState.getDefaultCityMessage());
        this.cityMessage.setText(currentState.getListCityMessage());
        this.eraseCityMessage.setText(currentState.getEraseCityMessage());
        this.tempUnitToggleSwitch.setSelected(currentState.getTempUnit());
        this.timeFormatToggleSwitch.setSelected(currentState.getIs24HourFormat());
        this.cityList.setListData(currentState.getCityList().toArray(new String[0]));
    }
}
