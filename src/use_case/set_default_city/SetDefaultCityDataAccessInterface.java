package use_case.set_default_city;

public interface SetDefaultCityDataAccessInterface {

    Boolean setDefaultCity(String city);
    // True if the city is set as default,
    // False if the city weather data is not found.
    // In this method, the DAO should check if the city is in the
    // favorite city list. If it is, then set it as default city
    // and delete from the city list.
}
