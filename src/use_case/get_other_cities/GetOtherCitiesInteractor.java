package use_case.get_other_cities;

import entity.Weather;
import java.util.ArrayList;
import java.time.LocalTime;


public class GetOtherCitiesInteractor implements GetOtherCitiesInputBoundary {

    private final OtherCitiesSettingsDataAccessInterface otherCitiesSettingsDataAccessObject;
    private final GetOtherCitiesDataAccessInterface getOtherCitiesDataAccessObject;
    private final GetOtherCitiesOutputBoundary getOtherCitiesPresenter;

    public GetOtherCitiesInteractor(
            OtherCitiesSettingsDataAccessInterface otherCitiesSettingsDataAccessObject,
            GetOtherCitiesDataAccessInterface getOtherCitiesDataAccessObject,
            GetOtherCitiesOutputBoundary getOtherCitiesPresenter
    ) {
        this.otherCitiesSettingsDataAccessObject = otherCitiesSettingsDataAccessObject;
        this.getOtherCitiesDataAccessObject = getOtherCitiesDataAccessObject;
        this.getOtherCitiesPresenter = getOtherCitiesPresenter;
    }

    @Override
    public void execute(LocalTime localTime) {
        // 使用settingsDAO来获取城市列表
        ArrayList<String> cityNames = otherCitiesSettingsDataAccessObject.getSettings().getSavedCities();

        // 现在有了城市列表，可以通过weatherService获取天气信息
        ArrayList<Weather> weatherList = getOtherCitiesDataAccessObject.fetchWeatherForCities(localTime, cityNames, otherCitiesSettingsDataAccessObject.getSettings().getCelsius());

        // 创建输出数据
        GetOtherCitiesOutputData getOtherCitiesoutputData = new GetOtherCitiesOutputData(weatherList);

        // 通过输出边界将天气信息传递给presenter
        getOtherCitiesPresenter.presentOtherCitiesWeather(getOtherCitiesoutputData);
    }
}
