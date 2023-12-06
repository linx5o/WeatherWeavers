package app;

import view.cities.CitiesView;

public class CitiesUseCaseFactory {
    private CitiesUseCaseFactory() {}

    public static CitiesView create() {
        try {
            return new CitiesView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
