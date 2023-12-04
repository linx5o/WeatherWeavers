package view.sidebar;

import app.ImportFont;
import interface_adapter.ChangeMainContent.ChangeMainContentController;
import interface_adapter.ChangeMainContent.ChangeMainContentPresenter;
import view.RoundedPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidebarView extends JPanel implements ActionListener {
    public final String viewName = "sidebar";

    private final ChangeMainContentController controller;
    private final JButton weatherButton;
    private final JButton citiesButton;
    private final JButton mapButton;
    private final JButton settingsButton;
    private final JLabel logoIcon = new JLabel();

    public SidebarView(ChangeMainContentController controller) {
        this.controller = controller;

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(100, 700));
        this.setBackground(Color.decode("#0D131D"));

        weatherButton = new JButton(new ImageIcon("src/app/weatherIcon.png"));
        citiesButton = new JButton(new ImageIcon("src/app/citiesIcon.png"));
        mapButton = new JButton(new ImageIcon("src/app/mapIcon.png"));
        settingsButton = new JButton(new ImageIcon("src/app/settingsIcon.png"));

        weatherButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(weatherButton)) {
                            controller.execute("weather");
                        }
                    }
                }
        );

        citiesButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(citiesButton)) {
                            controller.execute("cities");
                        }
                    }
                }
        );

        mapButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(mapButton)) {
                            controller.execute("map");
                        }
                    }
                }
        );

        settingsButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(settingsButton)) {
                            controller.execute("settings");
                        }
                    }
                }
        );

        RoundedPanel sidebarPanel = new RoundedPanel(40);

        sidebarPanel.setPreferredSize(new Dimension(60, 520));
        sidebarPanel.setBackground(Color.decode("#222B3A"));

        sidebarPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(20, 20, 160, 20);
        this.add(sidebarPanel, constraints);

        try {
            logoIcon.setIcon(new ImageIcon("src/app/logo.png"));
        } catch (Exception e) {
            System.out.println(e);
        }

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        sidebarPanel.add(logoIcon, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(30, 0, 0, 0);

        weatherButton.setPreferredSize(new Dimension(60, 45));
        weatherButton.setOpaque(false);
        weatherButton.setContentAreaFilled(false);
        weatherButton.setBorderPainted(false);
        weatherButton.setFocusPainted(false);

        sidebarPanel.add(weatherButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        JLabel weatherLabel = new JLabel("Weather");
        weatherLabel.setFont(ImportFont.getFont("ExtraLight", 12));
        weatherLabel.setForeground(Color.decode("#FFFFFF"));
        sidebarPanel.add(weatherLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.insets = new Insets(20, 0, 0, 0);
        citiesButton.setPreferredSize(new Dimension(60, 45));
        citiesButton.setOpaque(false);
        citiesButton.setContentAreaFilled(false);
        citiesButton.setBorderPainted(false);
        citiesButton.setFocusPainted(false);

        sidebarPanel.add(citiesButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.insets = new Insets(0, 0, 0, 0);
        JLabel citiesLabel = new JLabel("Cities");
        citiesLabel.setFont(ImportFont.getFont("ExtraLight", 12));
        citiesLabel.setForeground(Color.decode("#FFFFFF"));
        sidebarPanel.add(citiesLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.insets = new Insets(20, 0, 0, 0);
        mapButton.setPreferredSize(new Dimension(60, 45));
        mapButton.setOpaque(false);
        mapButton.setContentAreaFilled(false);
        mapButton.setBorderPainted(false);
        mapButton.setFocusPainted(false);

        sidebarPanel.add(mapButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.insets = new Insets(0, 0, 0, 0);
        JLabel mapLabel = new JLabel("Map");
        mapLabel.setFont(ImportFont.getFont("ExtraLight", 12));
        mapLabel.setForeground(Color.decode("#FFFFFF"));
        sidebarPanel.add(mapLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.insets = new Insets(20, 0, 0, 0);
        settingsButton.setPreferredSize(new Dimension(60, 45));
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        settingsButton.setFocusPainted(false);

        sidebarPanel.add(settingsButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.insets = new Insets(0, 0, 130, 0);
        JLabel settingsLabel = new JLabel("Settings");
        settingsLabel.setFont(ImportFont.getFont("ExtraLight", 12));
        settingsLabel.setForeground(Color.decode("#FFFFFF"));
        sidebarPanel.add(settingsLabel, constraints);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
