package app;

import interface_adapter.ViewManagerModel;
import view.ViewManager;
import view.weather.WeatherView;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame app = new JFrame("Weather");
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        app.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        WeatherView weatherView = new WeatherView();
        views.add(weatherView, weatherView.viewName);
    }
}
