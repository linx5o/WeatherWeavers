package data_access;

import entity.Humidity;
import use_case.humidity.HumidityDataAccessInterface;

public class HumidityDataAccessObject implements HumidityDataAccessInterface {
    @Override
    public Humidity getHumidity(String city, String date) {
        return null;
    }
}
