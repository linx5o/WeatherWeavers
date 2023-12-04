package view.settings;

import interface_adapter.Settings.SettingsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SettingsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "settings";
    public SettingsView(SettingsViewModel settingsViewModel) {
        // TODO - implement SettingsView.SettingsView
        this.add(new JLabel("SettingsView"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
