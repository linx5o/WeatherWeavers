package use_case.forecast;

import entity.Location;
import entity.Temperature;
import entity.Weather;

import java.util.List;

public interface ForecastDataAccessInterface {
    /**
     * @param days how many days should forecast have
     * @return list of weather in following days starting from today
     */
    List<Weather> getForecast(Location location, int days);
}
