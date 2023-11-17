package view.Weather;

import javax.swing.*;
import java.awt.*;

public class WeatherView extends JPanel {
    public final String viewName = "weather";

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public WeatherView(GridBagLayout gridBayLayout) {
        this.setLayout(gridBayLayout);
    }
}
