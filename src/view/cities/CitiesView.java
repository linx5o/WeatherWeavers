package view.cities;

import app.ImportFont;

import javax.swing.*;
import java.awt.*;

public class CitiesView extends JPanel {
    public final String viewName = "cities";

    public CitiesView() {
        this.setBackground(Color.decode("#0D131D"));
        this.setLayout(new GridBagLayout());

        JLabel title = new JLabel("Cities has not yet been implemented!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setForeground(Color.decode("#FFFFFF"));
        title.setFont(ImportFont.getFont("Bold", 40));

        this.add(title);
    }
}
