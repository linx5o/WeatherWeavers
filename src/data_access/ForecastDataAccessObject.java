package data_access;

import entity.Location;
import entity.Weather;
import use_case.forecast.ForecastDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class ForecastDataAccessObject implements ForecastDataAccessInterface {
    @Override
    public List<Weather> getForecast(Location location, int days) {
        ArrayList<Weather> weatherArrayList = new ArrayList<>();


        return  weatherArrayList;
    }
}
