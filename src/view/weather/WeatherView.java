package view.weather;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WeatherView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    public WeatherView() {
        JFrame frame = new JFrame("Swing Example");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Click Me!");
        frame.getContentPane().add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button was clicked!");
            }
        });

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: Implement
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //TODO: Implement
    }
}
