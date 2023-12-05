package view.settings;

import app.ImportFont;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class SettingsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "settings";

    private final JLabel defaultCityMessage = new JLabel();
    private final JLabel cityMessage = new JLabel();
    private final JLabel eraseCityMessage = new JLabel();
    private final JList<String> cityList = new JList<>();
    private final JTextField defaultCityCityInputField = new JTextField("E.g. Toronto",13);
    private final JTextField defaultCityCountryInputField = new JTextField(8);
    private final JTextField cityCityInputField = new JTextField(13);
    private final JTextField cityCountryInputField = new JTextField(8);
    private final JTextField eraseCityCityInputField = new JTextField(13);
    private final JTextField eraseCityCountryInputField = new JTextField(8);
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

        settingsViewModel.addPropertyChangeListener(this);

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

        // Default City Panel
        JLabel defaultCityTitle = new JLabel(settingsViewModel.DEFAULT_CITY_TITLE_LABEL);
        JLabel defaultCityCityLabel = new JLabel("City");
        JLabel defaultCityCountryLabel = new JLabel("State / Country");

        defaultCityTitle.setFont(ImportFont.getFont("Regular", 20));
        defaultCityTitle.setForeground(Color.decode("#FFFFFF"));

        defaultCityCityLabel.setFont(ImportFont.getFont("ExtraLight", 14));
        defaultCityCityLabel.setForeground(Color.decode("#FFFFFF"));

        defaultCityCountryLabel.setFont(ImportFont.getFont("ExtraLight", 14));
        defaultCityCountryLabel.setForeground(Color.decode("#FFFFFF"));

        GridBagConstraints defaultCityConstraints = new GridBagConstraints();

        defaultCityConstraints.gridx = 0;
        defaultCityConstraints.gridy = 0;
        defaultCityConstraints.gridwidth = 3;
        defaultCityConstraints.insets = new Insets(20, 20, 0, 388);
        defaultCityConstraints.anchor = GridBagConstraints.WEST;

        defaultCityPanel.add(defaultCityTitle, defaultCityConstraints);

        defaultCityConstraints.gridx = 0;
        defaultCityConstraints.gridy = 1;
        defaultCityConstraints.gridwidth = 1;
        defaultCityConstraints.insets = new Insets(19, 20, 0, 0);
        defaultCityConstraints.anchor = GridBagConstraints.WEST;

        defaultCityPanel.add(defaultCityCityLabel, defaultCityConstraints);

        defaultCityConstraints.gridx = 1;
        defaultCityConstraints.gridy = 1;
        defaultCityConstraints.gridwidth = 2;
        defaultCityConstraints.insets = new Insets(19, 20, 0, 0);
        defaultCityConstraints.anchor = GridBagConstraints.WEST;

        defaultCityPanel.add(defaultCityCountryLabel, defaultCityConstraints);

        RoundedPanel defaultCityCityInputPanel = new RoundedPanel(30);
        RoundedPanel defaultCityCountryInputPanel = new RoundedPanel(30);
        RoundedPanel defaultCityButtonPanel = new RoundedPanel(30);

        defaultCityCityInputPanel.setLayout(new GridBagLayout());
        defaultCityCityInputPanel.setPreferredSize(new Dimension(180, 30));
        defaultCityCityInputPanel.setBackground(Color.decode("#6B717A"));

        defaultCityCountryInputPanel.setLayout(new GridBagLayout());
        defaultCityCountryInputPanel.setPreferredSize(new Dimension(120, 30));
        defaultCityCountryInputPanel.setBackground(Color.decode("#6B717A"));

        defaultCityButtonPanel.setLayout(new GridBagLayout());
        defaultCityButtonPanel.setPreferredSize(new Dimension(120, 30));
        defaultCityButtonPanel.setBackground(Color.decode("#4193F7"));

        defaultCityConstraints.gridx = 0;
        defaultCityConstraints.gridy = 2;
        defaultCityConstraints.gridwidth = 1;
        defaultCityConstraints.insets = new Insets(5, 20, 0, 0);
        defaultCityConstraints.anchor = GridBagConstraints.WEST;

        defaultCityPanel.add(defaultCityCityInputPanel, defaultCityConstraints);

        defaultCityConstraints.gridx = 1;
        defaultCityConstraints.gridy = 2;
        defaultCityConstraints.gridwidth = 1;
        defaultCityConstraints.insets = new Insets(5, 20, 0, 0);
        defaultCityConstraints.anchor = GridBagConstraints.WEST;

        defaultCityPanel.add(defaultCityCountryInputPanel, defaultCityConstraints);

        defaultCityConstraints.gridx = 2;
        defaultCityConstraints.gridy = 2;
        defaultCityConstraints.gridwidth = 1;
        defaultCityConstraints.insets = new Insets(5, 20, 0, 20);
        defaultCityConstraints.anchor = GridBagConstraints.WEST;

        defaultCityPanel.add(defaultCityButtonPanel, defaultCityConstraints);

        defaultCityCityInputField.setFont(ImportFont.getFont("Light", 14));
        defaultCityCityInputField.setCaretColor(Color.decode("#FFFFFF"));
        defaultCityCityInputField.setOpaque(false);
        defaultCityCityInputField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        defaultCityCityInputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (defaultCityCityInputField.getText().equals("E.g. Toronto")) {
                    defaultCityCityInputField.setText("");
                    defaultCityCityInputField.setForeground(Color.decode("#FFFFFF"));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (defaultCityCityInputField.getText().isEmpty()) {
                    defaultCityCityInputField.setForeground(Color.decode("#D9D9D9"));
                    defaultCityCityInputField.setText("E.g. Toronto");
                }
            }
        });

        defaultCityCityInputPanel.add(defaultCityCityInputField);

        defaultCityCountryInputField.setFont(ImportFont.getFont("Light", 14));
        defaultCityCountryInputField.setCaretColor(Color.decode("#FFFFFF"));
        defaultCityCountryInputField.setOpaque(false);
        defaultCityCountryInputField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        defaultCityCountryInputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (defaultCityCountryInputField.getText().equals("E.g. ON")) {
                    defaultCityCountryInputField.setText("");
                    defaultCityCountryInputField.setForeground(Color.decode("#FFFFFF"));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (defaultCityCountryInputField.getText().isEmpty()) {
                    defaultCityCountryInputField.setForeground(Color.decode("#D9D9D9"));
                    defaultCityCountryInputField.setText("E.g. ON");
                }
            }
        });

        defaultCityCountryInputPanel.add(defaultCityCountryInputField);


        setDefaultCityButton.setFont(ImportFont.getFont("Regular", 14));
        setDefaultCityButton.setForeground(Color.decode("#FFFFFF"));
        setDefaultCityButton.setOpaque(false);
        setDefaultCityButton.setContentAreaFilled(false);
        setDefaultCityButton.setBorderPainted(false);
        setDefaultCityButton.setFocusPainted(false);

        setDefaultCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDefaultCityController.execute(defaultCityCityInputField.getText().toLowerCase() + ',' + defaultCityCountryInputField.getText().toLowerCase());
            }
        });

        defaultCityButtonPanel.add(setDefaultCityButton);

        defaultCityConstraints.gridx = 0;
        defaultCityConstraints.gridy = 3;
        defaultCityConstraints.gridwidth = 3;
        defaultCityConstraints.insets = new Insets(20, 20, 20, 0);

        defaultCityMessage.setFont(ImportFont.getFont("Regular", 16));
        defaultCityMessage.setForeground(Color.decode("#FFFFFF"));

        defaultCityPanel.add(defaultCityMessage, defaultCityConstraints);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SettingsState currentState = settingsViewModel.getState();
        if (currentState.getDefaultCityCity().isEmpty()) {
            this.defaultCityCityInputField.setForeground(Color.decode("#D9D9D9"));
            this.defaultCityCityInputField.setText("E.g. Toronto");
        } else {
            this.defaultCityCityInputField.setForeground(Color.decode("#FFFFFF"));
            this.defaultCityCityInputField.setText(currentState.getDefaultCityCity());
        }
        if (currentState.getDefaultCityCountry().isEmpty()) {
            this.defaultCityCountryInputField.setForeground(Color.decode("#D9D9D9"));
            this.defaultCityCountryInputField.setText("E.g. ON");
        } else {
            this.defaultCityCountryInputField.setForeground(Color.decode("#FFFFFF"));
            this.defaultCityCountryInputField.setText(currentState.getDefaultCityCountry());
        }
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
