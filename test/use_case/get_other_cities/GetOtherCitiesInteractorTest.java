package use_case.get_other_cities;

import entity.Settings;
import entity.Weather;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

class GetOtherCitiesInteractorTest {

    private GetOtherCitiesDataAccessInterface weatherDataAccess;
    private OtherCitiesSettingsDataAccessInterface settingsDataAccess;
    private GetOtherCitiesOutputBoundary outputBoundary;
    private GetOtherCitiesInteractor interactor;
    private List<Weather> testWeatherData;


    @Before
    void setUp() {
        // 创建并配置settingsDataAccess以返回预设的设置数据
        settingsDataAccess = new OtherCitiesSettingsDataAccessInterface() {
            @Override
            public Settings getSettings() {
                ArrayList<String> savedCities = new ArrayList<>();
                savedCities.add("City1,ca");
                savedCities.add("City2,ca");
                // 创建并返回包含这些城市的Settings对象
                return new Settings(true, true, true, "City1,ca", savedCities);
            }
        };

        // 创建并配置weatherDataAccess以返回预设的天气数据
        weatherDataAccess = new GetOtherCitiesDataAccessInterface() {
            @Override
            public ArrayList<Weather> fetchWeatherForCities(LocalTime localTime, ArrayList<String> savedCities, Boolean celsius) {
                ArrayList<Weather> weatherList = new ArrayList<>();
                for (String city : savedCities) {
                    weatherList.add(new Weather(
                            "descriptions", // descriptions
                            20,    // currentTemp
                            30,    // highTemp
                            10,    // lowTemp
                            city,  // city
                            celsius,  // celsius
                            5,     // windSpeed
                            80,    // rainPercent
                            "06:00",  // sunrise
                            "18:00"   // sunset
                    ));
                }
                return weatherList;
            }
        };

        // 创建一个模拟的outputBoundary
        GetOtherCitiesOutputBoundary testOutputBoundary = new GetOtherCitiesOutputBoundary() {
            @Override
            public void presentOtherCitiesWeather(GetOtherCitiesOutputData response) {
                // 检查两件事：输出数据是否正确，以及天气信息是否如预期创建
                assertNotNull(response);
                ArrayList<ArrayList<String>> weatherData = response.getCitiesWeatherInfo();
                assertFalse("The list of weathers should not be empty", weatherData.isEmpty());
                ArrayList<String> firstCityWeather = weatherData.get(0);
                assertEquals("City1,ca", firstCityWeather.get(0));
            }
        };


        // 创建interactor实例
        interactor = new GetOtherCitiesInteractor(settingsDataAccess, weatherDataAccess, outputBoundary);
    }


    @Test
    void testGetWeatherInfoForOtherCities() {
        // 获取当前时间
        LocalTime currentTime = LocalTime.now();

        // 执行Interactor,会跳到匿名的outputboundary去执行assert
        interactor.execute(currentTime);

    }


}


