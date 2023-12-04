package use_case.erase_city;

import entity.Settings;

public interface EraseCityDataAccessInterface {

    Boolean eraseCity(String city);
    // return true if success, false if city not found

    Settings getSettings();
}
