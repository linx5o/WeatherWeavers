package use_case.set_city;

import java.util.ArrayList;
import entity.Settings;

public interface SetCityDataAccessInterface {
    int addCity(String city);
    // return 0 if success,
    // 1 if city already exists,
    // 2 if city is the default city,
    // 3 if city is not found

    Settings getSettings();
}
