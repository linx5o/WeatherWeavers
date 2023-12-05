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
    private final JLabel city1 = new JLabel();
    private final JLabel city2 = new JLabel();
    private final JLabel city3 = new JLabel();
    private final JLabel city4 = new JLabel();
    private final JLabel city5 = new JLabel();
    private final JLabel city6 = new JLabel();
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
        defaultCityConstraints.insets = new Insets(19, 20, 0 , 0);
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


        // Toggles Panel

        JLabel togglesTitle = new JLabel(settingsViewModel.TOGGLES_TITLE_LABEL);
        JLabel tempUnitLabel = new JLabel("Celsius");
        JLabel timeFormatLabel = new JLabel("24 Hour Format");

        togglesTitle.setFont(ImportFont.getFont("Regular", 20));
        togglesTitle.setForeground(Color.decode("#FFFFFF"));

        tempUnitLabel.setFont(ImportFont.getFont("ExtraLight", 14));
        tempUnitLabel.setForeground(Color.decode("#FFFFFF"));

        timeFormatLabel.setFont(ImportFont.getFont("ExtraLight", 14));
        timeFormatLabel.setForeground(Color.decode("#FFFFFF"));

        GridBagConstraints togglesConstraints = new GridBagConstraints();

        togglesConstraints.gridx = 0;
        togglesConstraints.gridy = 0;
        togglesConstraints.gridwidth = 2;
        togglesConstraints.insets = new Insets(20, 20, 0, 265);
        togglesConstraints.anchor = GridBagConstraints.WEST;

        togglesPanel.add(togglesTitle, togglesConstraints);

        togglesConstraints.gridx = 0;
        togglesConstraints.gridy = 1;
        togglesConstraints.gridwidth = 1;
        togglesConstraints.insets = new Insets(19, 20, 0, 0);
        togglesConstraints.anchor = GridBagConstraints.WEST;

        togglesPanel.add(tempUnitLabel, togglesConstraints);

        togglesConstraints.gridx = 1;
        togglesConstraints.gridy = 1;
        togglesConstraints.gridwidth = 1;
        togglesConstraints.insets = new Insets(19, 0, 0, 40);
        togglesConstraints.anchor = GridBagConstraints.EAST;

        tempUnitToggleSwitch.setMinimumSize(new Dimension(40, 20));
        tempUnitToggleSwitch.setBorderPainted(false);

        tempUnitToggleSwitch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTempUnitController.execute();
            }
        });

        togglesPanel.add(tempUnitToggleSwitch, togglesConstraints);

        togglesConstraints.gridx = 0;
        togglesConstraints.gridy = 2;
        togglesConstraints.gridwidth = 1;
        togglesConstraints.insets = new Insets(30, 20, 42, 0);
        togglesConstraints.anchor = GridBagConstraints.WEST;

        togglesPanel.add(timeFormatLabel, togglesConstraints);

        togglesConstraints.gridx = 1;
        togglesConstraints.gridy = 2;
        togglesConstraints.gridwidth = 1;
        togglesConstraints.insets = new Insets(30, 0, 42, 40);
        togglesConstraints.anchor = GridBagConstraints.EAST;

        timeFormatToggleSwitch.setMinimumSize(new Dimension(40, 20));
        timeFormatToggleSwitch.setBorderPainted(false);

        timeFormatToggleSwitch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTimeFormatController.execute();
            }
        });

        togglesPanel.add(timeFormatToggleSwitch, togglesConstraints);

        // City List Panel

        JLabel cityListTitle = new JLabel(settingsViewModel.CITY_LIST_TITLE_LABEL);

        cityListTitle.setFont(ImportFont.getFont("Regular", 20));
        cityListTitle.setForeground(Color.decode("#FFFFFF"));

        JPanel cityListLeftPanel = new JPanel();
        JPanel cityListRightPanel = new JPanel();

        cityListLeftPanel.setLayout(new GridBagLayout());
        cityListLeftPanel.setPreferredSize(new Dimension(360, 380));
        cityListLeftPanel.setOpaque(false);

        cityListRightPanel.setLayout(new GridBagLayout());
        cityListRightPanel.setPreferredSize(new Dimension(540, 380));
        cityListRightPanel.setOpaque(false);

        GridBagConstraints cityListLeft = new GridBagConstraints();

        cityListLeft.gridx = 0;
        cityListLeft.gridy = 0;
        cityListLeft.gridwidth = 1;
        cityListLeft.insets = new Insets(20, 20, 0, 188);
        cityListLeft.anchor = GridBagConstraints.WEST;

        cityListLeftPanel.add(cityListTitle, cityListLeft);

        cityListLeft.gridx = 0;
        cityListLeft.gridy = 1;
        cityListLeft.gridwidth = 1;
        cityListLeft.insets = new Insets(20, 40, 20, 20);
        cityListLeft.anchor = GridBagConstraints.WEST;

        JPanel cityPanel = new JPanel();
        cityPanel.setLayout(new GridBagLayout());

        cityPanel.setOpaque(false);

//        city1.setText("City 1:");
        city1.setFont(ImportFont.getFont("Medium", 26));
        city1.setForeground(Color.decode("#D9D9D9"));
//        city2.setText("City 2:");
        city2.setFont(ImportFont.getFont("Medium", 26));
        city2.setForeground(Color.decode("#D9D9D9"));
//        city3.setText("City 3:");
        city3.setFont(ImportFont.getFont("Medium", 26));
        city3.setForeground(Color.decode("#D9D9D9"));
//        city4.setText("City 4:");
        city4.setFont(ImportFont.getFont("Medium", 26));
        city4.setForeground(Color.decode("#D9D9D9"));
//        city5.setText("City 5:");
        city5.setFont(ImportFont.getFont("Medium", 26));
        city5.setForeground(Color.decode("#D9D9D9"));
//        city6.setText("City 6:");
        city6.setFont(ImportFont.getFont("Medium", 26));
        city6.setForeground(Color.decode("#D9D9D9"));

        GridBagConstraints cityConstraints = new GridBagConstraints();

        cityConstraints.gridx = 0;
        cityConstraints.gridy = 0;
        cityConstraints.anchor = GridBagConstraints.WEST;
        cityConstraints.insets = new Insets(5, 0, 5, 0);

        cityPanel.add(city1, cityConstraints);

        cityConstraints.gridx = 0;
        cityConstraints.gridy = 1;

        cityPanel.add(city2, cityConstraints);

        cityConstraints.gridx = 0;
        cityConstraints.gridy = 2;

        cityPanel.add(city3, cityConstraints);

        cityConstraints.gridx = 0;
        cityConstraints.gridy = 3;

        cityPanel.add(city4, cityConstraints);

        cityConstraints.gridx = 0;
        cityConstraints.gridy = 4;

        cityPanel.add(city5, cityConstraints);

        cityConstraints.gridx = 0;
        cityConstraints.gridy = 5;
        cityConstraints.insets = new Insets(5, 0, 37, 0);

        cityPanel.add(city6, cityConstraints);

        cityListLeftPanel.add(cityPanel, cityListLeft);


        JPanel cityListRightTopPanel = new JPanel();
        JPanel cityListRightBottomPanel = new JPanel();

        cityListRightTopPanel.setLayout(new GridBagLayout());
        cityListRightTopPanel.setPreferredSize(new Dimension(540, 190));
        cityListRightTopPanel.setOpaque(false);

        cityListRightBottomPanel.setLayout(new GridBagLayout());
        cityListRightBottomPanel.setPreferredSize(new Dimension(540, 190));
        cityListRightBottomPanel.setOpaque(false);

        JLabel cityListAdd = new JLabel("Add City");
        JLabel cityListErase = new JLabel("Remove City");

        JLabel cityListAddCityLabel = new JLabel("City");
        JLabel cityListAddCountryLabel = new JLabel("State / Country");
        JLabel cityListEraseCityLabel = new JLabel("City");
        JLabel cityListEraseCountryLabel = new JLabel("State / Country");

        cityListAddCityLabel.setFont(ImportFont.getFont("ExtraLight", 14));
        cityListAddCityLabel.setForeground(Color.decode("#FFFFFF"));
        cityListAddCountryLabel.setFont(ImportFont.getFont("ExtraLight", 14));
        cityListAddCountryLabel.setForeground(Color.decode("#FFFFFF"));
        cityListEraseCityLabel.setFont(ImportFont.getFont("ExtraLight", 14));
        cityListEraseCityLabel.setForeground(Color.decode("#FFFFFF"));
        cityListEraseCountryLabel.setFont(ImportFont.getFont("ExtraLight", 14));
        cityListEraseCountryLabel.setForeground(Color.decode("#FFFFFF"));

        cityListAdd.setFont(ImportFont.getFont("Regular", 20));
        cityListAdd.setForeground(Color.decode("#FFFFFF"));

        cityListErase.setFont(ImportFont.getFont("Regular", 20));
        cityListErase.setForeground(Color.decode("#FFFFFF"));

//        cityListRightTopPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#555555"), 1));
//        cityListRightBottomPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#555555"), 1));
//        cityListAdd.setBorder(BorderFactory.createLineBorder(Color.decode("#555555"), 1));
//        cityListErase.setBorder(BorderFactory.createLineBorder(Color.decode("#555555"), 1));

        GridBagConstraints cityRight = new GridBagConstraints();

        cityRight.gridx = 0;
        cityRight.gridy = 0;
        cityRight.gridwidth = 3;
        cityRight.anchor = GridBagConstraints.WEST;
        cityRight.insets = new Insets(20, 20, 0, 0);

        cityListRightTopPanel.add(cityListAdd, cityRight);
        cityListRightBottomPanel.add(cityListErase, cityRight);

        cityRight.gridx = 0;
        cityRight.gridy = 1;
        cityRight.gridwidth = 1;
        cityRight.anchor = GridBagConstraints.WEST;
        cityRight.insets = new Insets(24, 20, 0, 0);

        cityListRightTopPanel.add(cityListAddCityLabel, cityRight);
        cityListRightBottomPanel.add(cityListEraseCityLabel, cityRight);

        cityRight.gridx = 1;
        cityRight.gridy = 1;
        cityRight.gridwidth = 2;
        cityRight.anchor = GridBagConstraints.WEST;
        cityRight.insets = new Insets(24, 20, 0, 0);

        cityListRightTopPanel.add(cityListAddCountryLabel, cityRight);
        cityListRightBottomPanel.add(cityListEraseCountryLabel, cityRight);

        RoundedPanel cityListAddCityInputPanel = new RoundedPanel(30);
        RoundedPanel cityListAddCountryInputPanel = new RoundedPanel(30);
        RoundedPanel cityListAddButtonPanel = new RoundedPanel(30);
        RoundedPanel cityListEraseCityInputPanel = new RoundedPanel(30);
        RoundedPanel cityListEraseCountryInputPanel = new RoundedPanel(30);
        RoundedPanel cityListEraseButtonPanel = new RoundedPanel(30);

        cityListAddCityInputPanel.setLayout(new GridBagLayout());
        cityListAddCityInputPanel.setPreferredSize(new Dimension(180, 30));
        cityListAddCityInputPanel.setBackground(Color.decode("#6B717A"));

        cityListAddCountryInputPanel.setLayout(new GridBagLayout());
        cityListAddCountryInputPanel.setPreferredSize(new Dimension(120, 30));
        cityListAddCountryInputPanel.setBackground(Color.decode("#6B717A"));

        cityListAddButtonPanel.setLayout(new GridBagLayout());
        cityListAddButtonPanel.setPreferredSize(new Dimension(120, 30));
        cityListAddButtonPanel.setBackground(Color.decode("#4193F7"));

        cityListEraseCityInputPanel.setLayout(new GridBagLayout());
        cityListEraseCityInputPanel.setPreferredSize(new Dimension(180, 30));
        cityListEraseCityInputPanel.setBackground(Color.decode("#6B717A"));

        cityListEraseCountryInputPanel.setLayout(new GridBagLayout());
        cityListEraseCountryInputPanel.setPreferredSize(new Dimension(120, 30));
        cityListEraseCountryInputPanel.setBackground(Color.decode("#6B717A"));

        cityListEraseButtonPanel.setLayout(new GridBagLayout());
        cityListEraseButtonPanel.setPreferredSize(new Dimension(120, 30));
        cityListEraseButtonPanel.setBackground(Color.decode("#4193F7"));

        cityRight.gridx = 0;
        cityRight.gridy = 2;
        cityRight.gridwidth = 1;
        cityRight.anchor = GridBagConstraints.WEST;
        cityRight.insets = new Insets(5, 20, 0, 0);

        cityListRightTopPanel.add(cityListAddCityInputPanel, cityRight);
        cityListRightBottomPanel.add(cityListEraseCityInputPanel, cityRight);

        cityRight.gridx = 1;
        cityRight.gridy = 2;
        cityRight.gridwidth = 1;
        cityRight.anchor = GridBagConstraints.WEST;
        cityRight.insets = new Insets(5, 20, 0, 0);

        cityListRightTopPanel.add(cityListAddCountryInputPanel, cityRight);
        cityListRightBottomPanel.add(cityListEraseCountryInputPanel, cityRight);

        cityRight.gridx = 2;
        cityRight.gridy = 2;
        cityRight.gridwidth = 1;
        cityRight.anchor = GridBagConstraints.WEST;
        cityRight.insets = new Insets(5, 20, 0, 20);

        cityListRightTopPanel.add(cityListAddButtonPanel, cityRight);
        cityListRightBottomPanel.add(cityListEraseButtonPanel, cityRight);

        cityCityInputField.setFont(ImportFont.getFont("Light", 14));
        cityCityInputField.setCaretColor(Color.decode("#FFFFFF"));
        cityCityInputField.setOpaque(false);
        cityCityInputField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        cityCityInputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (cityCityInputField.getText().equals("E.g. Toronto")) {
                    cityCityInputField.setText("");
                    cityCityInputField.setForeground(Color.decode("#FFFFFF"));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (cityCityInputField.getText().isEmpty()) {
                    cityCityInputField.setForeground(Color.decode("#D9D9D9"));
                    cityCityInputField.setText("E.g. Toronto");
                }
            }
        });

        cityListAddCityInputPanel.add(cityCityInputField);

        cityCountryInputField.setFont(ImportFont.getFont("Light", 14));
        cityCountryInputField.setCaretColor(Color.decode("#FFFFFF"));
        cityCountryInputField.setOpaque(false);
        cityCountryInputField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        cityCountryInputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (cityCountryInputField.getText().equals("E.g. ON")) {
                    cityCountryInputField.setText("");
                    cityCountryInputField.setForeground(Color.decode("#FFFFFF"));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (cityCountryInputField.getText().isEmpty()) {
                    cityCountryInputField.setForeground(Color.decode("#D9D9D9"));
                    cityCountryInputField.setText("E.g. ON");
                }
            }
        });

        cityListAddCountryInputPanel.add(cityCountryInputField);

        setCityButton.setFont(ImportFont.getFont("Regular", 14));
        setCityButton.setForeground(Color.decode("#FFFFFF"));
        setCityButton.setOpaque(false);
        setCityButton.setContentAreaFilled(false);
        setCityButton.setBorderPainted(false);
        setCityButton.setFocusPainted(false);

        setCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!cityCityInputField.getText().equals("E.g. Toronto") && !cityCountryInputField.getText().equals("E.g. ON")) {
                    setCityController.execute(cityCityInputField.getText().toLowerCase() + ',' + cityCountryInputField.getText().toLowerCase());
                }
            }
        });

        cityListAddButtonPanel.add(setCityButton);

        eraseCityCityInputField.setFont(ImportFont.getFont("Light", 14));
        eraseCityCityInputField.setCaretColor(Color.decode("#FFFFFF"));
        eraseCityCityInputField.setOpaque(false);
        eraseCityCityInputField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        eraseCityCityInputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (eraseCityCityInputField.getText().equals("E.g. Toronto")) {
                    eraseCityCityInputField.setText("");
                    eraseCityCityInputField.setForeground(Color.decode("#FFFFFF"));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (eraseCityCityInputField.getText().isEmpty()) {
                    eraseCityCityInputField.setForeground(Color.decode("#D9D9D9"));
                    eraseCityCityInputField.setText("E.g. Toronto");
                }
            }
        });

        cityListEraseCityInputPanel.add(eraseCityCityInputField);

        eraseCityCountryInputField.setFont(ImportFont.getFont("Light", 14));
        eraseCityCountryInputField.setCaretColor(Color.decode("#FFFFFF"));
        eraseCityCountryInputField.setOpaque(false);
        eraseCityCountryInputField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        eraseCityCountryInputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (eraseCityCountryInputField.getText().equals("E.g. ON")) {
                    eraseCityCountryInputField.setText("");
                    eraseCityCountryInputField.setForeground(Color.decode("#FFFFFF"));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (eraseCityCountryInputField.getText().isEmpty()) {
                    eraseCityCountryInputField.setForeground(Color.decode("#D9D9D9"));
                    eraseCityCountryInputField.setText("E.g. ON");
                }
            }
        });

        cityListEraseCountryInputPanel.add(eraseCityCountryInputField);

        eraseCityButton.setFont(ImportFont.getFont("Regular", 14));
        eraseCityButton.setForeground(Color.decode("#FFFFFF"));
        eraseCityButton.setOpaque(false);
        eraseCityButton.setContentAreaFilled(false);
        eraseCityButton.setBorderPainted(false);
        eraseCityButton.setFocusPainted(false);

        eraseCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!eraseCityCityInputField.getText().equals("E.g. Toronto") && !eraseCityCountryInputField.getText().equals("E.g. ON")) {
                    eraseCityController.execute(eraseCityCityInputField.getText().toLowerCase() + ',' + eraseCityCountryInputField.getText().toLowerCase());
                }
            }
        });

        cityListEraseButtonPanel.add(eraseCityButton);

        setCityButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        eraseCityButton.setAlignmentY(Component.CENTER_ALIGNMENT);

        cityRight.gridx = 0;
        cityRight.gridy = 3;
        cityRight.gridwidth = 3;
        cityRight.anchor = GridBagConstraints.WEST;
        cityRight.insets = new Insets(20, 20, 25, 0);

        cityListRightTopPanel.add(cityMessage, cityRight);
        cityListRightBottomPanel.add(eraseCityMessage, cityRight);

        cityMessage.setFont(ImportFont.getFont("Regular", 16));
//        cityMessage.setForeground(Color.decode("#FFFFFF"));

        eraseCityMessage.setFont(ImportFont.getFont("Regular", 16));
//        eraseCityMessage.setForeground(Color.decode("#FFFFFF"));


        GridBagConstraints cityListRight = new GridBagConstraints();

        cityListRight.gridx = 0;
        cityListRight.gridy = 0;
        cityListRight.insets = new Insets(0, 0, 0, 0);

        cityListRightPanel.add(cityListRightTopPanel, cityListRight);

        cityListRight.gridx = 0;
        cityListRight.gridy = 1;

        cityListRightPanel.add(cityListRightBottomPanel, cityListRight);


        GridBagConstraints cityListConstraints = new GridBagConstraints();

        cityListConstraints.gridx = 0;
        cityListConstraints.gridy = 0;

        cityListPanel.add(cityListLeftPanel, cityListConstraints);

        cityListConstraints.gridx = 1;
        cityListConstraints.gridy = 0;

        cityListPanel.add(cityListRightPanel, cityListConstraints);

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
        if (currentState.getListCityCity().isEmpty()) {
            this.cityCityInputField.setForeground(Color.decode("#D9D9D9"));
            this.cityCityInputField.setText("E.g. Toronto");
        } else {
            this.cityCityInputField.setForeground(Color.decode("#FFFFFF"));
            this.cityCityInputField.setText(currentState.getListCityCity());
        }
        if (currentState.getListCityCountry().isEmpty()) {
            this.cityCountryInputField.setForeground(Color.decode("#D9D9D9"));
            this.cityCountryInputField.setText("E.g. ON");
        } else {
            this.cityCountryInputField.setForeground(Color.decode("#FFFFFF"));
            this.cityCountryInputField.setText(currentState.getListCityCountry());
        }
        if (currentState.getEraseCityCity().isEmpty()) {
            this.eraseCityCityInputField.setForeground(Color.decode("#D9D9D9"));
            this.eraseCityCityInputField.setText("E.g. Toronto");
        } else {
            this.eraseCityCityInputField.setForeground(Color.decode("#FFFFFF"));
            this.eraseCityCityInputField.setText(currentState.getEraseCityCity());
        }
        if (currentState.getEraseCityCountry().isEmpty()) {
            this.eraseCityCountryInputField.setForeground(Color.decode("#D9D9D9"));
            this.eraseCityCountryInputField.setText("E.g. ON");
        } else {
            this.eraseCityCountryInputField.setForeground(Color.decode("#FFFFFF"));
            this.eraseCityCountryInputField.setText(currentState.getEraseCityCountry());
        }
        this.defaultCityMessage.setText(currentState.getDefaultCityMessage());
        if (currentState.getListCityMessage().isEmpty()) {
            this.cityMessage.setText("Placeholder");
            cityMessage.setForeground(Color.decode("#222B3A"));
        } else {
            this.cityMessage.setText(currentState.getListCityMessage());
            cityMessage.setForeground(Color.decode("#FFFFFF"));
        }
        if (currentState.getEraseCityMessage().isEmpty()) {
            this.eraseCityMessage.setText("Placeholder");
            eraseCityMessage.setForeground(Color.decode("#222B3A"));
        } else {
            this.eraseCityMessage.setText(currentState.getEraseCityMessage());
            eraseCityMessage.setForeground(Color.decode("#FFFFFF"));
        }
        this.tempUnitToggleSwitch.setSelected(currentState.getTempUnit());
        this.timeFormatToggleSwitch.setSelected(currentState.getIs24HourFormat());
        if (currentState.getCityList().size() > 0) {
            this.city1.setText("City 1: " + currentState.getCityList().get(0));
        } else {
            this.city1.setText("City 1:");
            this.city2.setText("City 2:");
            this.city3.setText("City 3:");
            this.city4.setText("City 4:");
            this.city5.setText("City 5:");
            this.city6.setText("City 6:");
        }
        if (currentState.getCityList().size() > 1) {
            this.city2.setText("City 2: " + currentState.getCityList().get(1));
        } else {
            this.city2.setText("City 2:");
            this.city3.setText("City 3:");
            this.city4.setText("City 4:");
            this.city5.setText("City 5:");
            this.city6.setText("City 6:");
        }
        if (currentState.getCityList().size() > 2) {
            this.city3.setText("City 3: " + currentState.getCityList().get(2));
        } else {
            this.city3.setText("City 3:");
            this.city4.setText("City 4:");
            this.city5.setText("City 5:");
            this.city6.setText("City 6:");
        }
        if (currentState.getCityList().size() > 3) {
            this.city4.setText("City 4: " + currentState.getCityList().get(3));
        } else {
            this.city4.setText("City 4:");
            this.city5.setText("City 5:");
            this.city6.setText("City 6:");
        }
        if (currentState.getCityList().size() > 4) {
            this.city5.setText("City 5: " + currentState.getCityList().get(4));
        } else {
            this.city5.setText("City 5:");
            this.city6.setText("City 6:");
        }
        if (currentState.getCityList().size() > 5) {
            this.city6.setText("City 6: " + currentState.getCityList().get(5));
        } else {
            this.city6.setText("City 6:");
        }

    }

}
