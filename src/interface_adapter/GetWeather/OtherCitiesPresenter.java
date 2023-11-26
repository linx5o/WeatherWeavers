package interface_adapter.GetWeather;

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
            ArrayList<String> list = response.getCitiesWeatherInfo().get(i);
            OtherCitiesState.CityWeather cityWeather = new OtherCitiesState.CityWeather("","", "");
            cityWeather.setCityName(list.get(0));
            cityWeather.setWeatherCondition(list.get(1));
            cityWeather.setTemperature(list.get(2));
            cityWeathers_list.add(cityWeather);
        }
        state.setOtherCitiesWeather(cityWeathers_list);
        otherCitiesViewModel.setState(state);
    }
}
