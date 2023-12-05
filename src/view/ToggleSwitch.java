package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToggleSwitch extends JToggleButton {
    private Color switchColor = Color.WHITE;
    private Color buttonColor = new Color(76, 176, 80);
    private Color inactiveColor = new Color(204, 204, 204);

    public ToggleSwitch() {
        super();
        setPreferredSize(new Dimension(50, 30));
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(isSelected() ? buttonColor : inactiveColor);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        int toggleLocation = isSelected() ? getWidth() - getHeight() : 0;
        g.setColor(switchColor);
        g.fillOval(toggleLocation, 0, getHeight(), getHeight());
        super.paintComponent(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Toggle Switch Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        ToggleSwitch toggleSwitch = new ToggleSwitch();
        toggleSwitch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Toggle Switch is " + (toggleSwitch.isSelected() ? "on" : "off"));
            }
        });

        ToggleSwitch toggleSwitch2 = new ToggleSwitch();
        toggleSwitch2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Toggle Switch is " + (toggleSwitch2.isSelected() ? "on" : "off"));
            }
        });

        ToggleSwitch toggleSwitch3 = new ToggleSwitch();
        toggleSwitch3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Toggle Switch is " + (toggleSwitch3.isSelected() ? "on" : "off"));
            }
        });

        toggleSwitch.setBorderPainted(false);
        toggleSwitch2.setBorderPainted(false);
        toggleSwitch3.setBorderPainted(false);

        frame.add(toggleSwitch);
        frame.add(toggleSwitch2);
        frame.add(toggleSwitch3);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}