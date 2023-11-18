package use_case.humidity;

import entity.Humidity;

public interface HumidityDataAccessInterface {
    Humidity getHumidity(String city, String date);
}
