package app;

import interface_adapter.ViewManagerModel;
import view.ViewManager;
import javax.swing.*;
import java.awt.*;
import view.RoundedPanel;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Weather Weavers");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        app.setSize(1020, 700);
//        application.setLayout(new GridBagLayout());

        JPanel app = new JPanel(new GridBagLayout());

        app.setBackground(Color.decode("#0D131D"));

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 4;
        c.insets = new Insets(20, 20, 0, 20);
        RoundedPanel a = new RoundedPanel(20);
        a.setPreferredSize(new Dimension(60, 520));
        a.setBackground(Color.decode("#222B3A"));
        app.add(a, c);

        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(20, 0, 20, 0);
        RoundedPanel b = new RoundedPanel(20);
        b.setPreferredSize(new Dimension(620, 40));
        b.setBackground(Color.decode("#222B3A"));
        app.add(b, c);

        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(80, 0, 0, 0);
        JPanel mainContent = new JPanel(new GridBagLayout());
        mainContent.setPreferredSize(new Dimension(620, 260));
        mainContent.setBackground(Color.gray);
        app.add(mainContent, c);

        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(360, 0, 0, 0);
        RoundedPanel d = new RoundedPanel(20);
        d.setPreferredSize(new Dimension(420, 180));
        d.setBackground(Color.decode("#222B3A"));
        app.add(d, c);

        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(360, 440, 0, 20);
        RoundedPanel e = new RoundedPanel(20);
        e.setPreferredSize(new Dimension(180, 180));
        e.setBackground(Color.decode("#222B3A"));
        app.add(e, c);

        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 3;
        c.insets = new Insets(20, 0, 20, 0);
        RoundedPanel f = new RoundedPanel(20);
        f.setPreferredSize(new Dimension(900, 120));
        f.setBackground(Color.decode("#222B3A"));
        app.add(f, c);

        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 3;
        c.gridy = 2;
        c.insets = new Insets(80, 20, 0, 20);
        RoundedPanel g = new RoundedPanel(20);
        g.setPreferredSize(new Dimension(260, 460));
        g.setBackground(Color.decode("#222B3A"));
        app.add(g, c);

        application.add(app);

        application.pack();
        application.setResizable(false);
        application.setVisible(true);
    }
}
