package data_access;

import entity.Weather;
import use_case.forecast.ForecastDataAccessInterface;

import java.util.List;

public class ForecastDataAccessObject implements ForecastDataAccessInterface {
    @Override
    public List<Weather> getForecastTemp(int days) {
        return null;
    }
}
