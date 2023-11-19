package use_case.get_other_cities;

import data_access.GetSettingsDAO;
import java.util.List;

public class GetOtherCitiesInteractor implements GetOtherCitiesInputBoundary {

    private final GetSettingsDAO settingsDAO;
    private final WeatherInfoService weatherService;
    private final GetOtherCitiesOutputBoundary outputBoundary;

    public GetOtherCitiesInteractor(
            GetSettingsDAO settingsDAO,
            WeatherInfoService weatherService,
            GetOtherCitiesOutputBoundary outputBoundary
    ) {
        this.settingsDAO = settingsDAO;
        this.weatherService = weatherService;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void getWeatherInfo(long timestamp) {
        // 使用settingsDAO来获取城市列表
        List<String> cityNames = settingsDAO.getCityList();

        // 现在有了城市列表，可以通过weatherService获取天气信息
        List<CityWeatherInfo> weatherInfoList = weatherService.fetchWeatherForCities(timestamp, cityNames);

        // 创建输出数据
        GetOtherCitiesOutputData outputData = new GetOtherCitiesOutputData(weatherInfoList);

        // 通过输出边界将天气信息传递给presenter
        outputBoundary.presentOtherCitiesWeather(outputData);
    }
}
