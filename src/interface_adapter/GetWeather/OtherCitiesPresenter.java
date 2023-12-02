package interface_adapter.GetWeather;

import org.jetbrains.annotations.NotNull;
import use_case.get_other_cities.GetOtherCitiesOutputBoundary;
import use_case.get_other_cities.GetOtherCitiesOutputData;

import java.util.ArrayList;

public class OtherCitiesPresenter implements GetOtherCitiesOutputBoundary {

    private final OtherCitiesViewModel otherCitiesViewModel;

    public OtherCitiesPresenter(OtherCitiesViewModel otherCitiesViewModel) {
        this.otherCitiesViewModel = otherCitiesViewModel;
    }

    @Override
    public void presentOtherCitiesWeather(GetOtherCitiesOutputData response) {
        OtherCitiesState state = otherCitiesViewModel.getState();
        ArrayList<OtherCitiesState.CityWeather> cityWeathers_list = new ArrayList<>();
        //遍历outputdata里面的list of list 的每个list，重构成CityWeather class
        for (int i = 0;i<response.getCitiesWeatherInfo().size();i++) {
            OtherCitiesState.CityWeather cityWeather = getCityWeather(response, i);
            cityWeathers_list.add(cityWeather);
        }
        while (cityWeathers_list.size()<6) {
            OtherCitiesState.CityWeather cityWeather = new OtherCitiesState.CityWeather("","", "");
            cityWeathers_list.add(cityWeather);
        }
        
        state.setOtherCitiesWeather(cityWeathers_list);
        otherCitiesViewModel.setState(state);
    }

    @NotNull
    private static OtherCitiesState.CityWeather getCityWeather(GetOtherCitiesOutputData response, int i) {
        ArrayList<String> list = response.getCitiesWeatherInfo().get(i);
        OtherCitiesState.CityWeather cityWeather = new OtherCitiesState.CityWeather("","", "");
        String city = list.get(0);
        int commaIndex = city.indexOf(",");
        if (commaIndex != -1) {
            city = city.substring(0, commaIndex);
        }
        city = city.substring(0, 1).toUpperCase() + city.substring(1);
        cityWeather.setCityName(city);
        cityWeather.setWeatherCondition(list.get(1));
        cityWeather.setTemperature(list.get(2) + "°");
        return cityWeather;
    }
}
