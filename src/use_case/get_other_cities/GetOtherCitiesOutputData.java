package use_case.get_other_cities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import entity.Weather;

public class GetOtherCitiesOutputData {
    private final ArrayList<ArrayList<String>> citiesWeatherInfo = new ArrayList<>();

    public GetOtherCitiesOutputData(ArrayList<Weather> citiesWeatherInfo) {
        for (Weather weather : citiesWeatherInfo) {
            ArrayList<String> cityWeatherInfo = new ArrayList<String>();
            cityWeatherInfo.add(weather.getCity());
            cityWeatherInfo.add(weather.getDescriptions());
            cityWeatherInfo.add(weather.getCurrentTemp().toString());
            cityWeatherInfo.add(weather.getHighTemp().toString());
            cityWeatherInfo.add(weather.getLowTemp().toString());
            cityWeatherInfo.add(weather.getWindSpeed().toString());
            cityWeatherInfo.add(weather.getRainPercent().toString());
            cityWeatherInfo.add(weather.getSunrise());
            cityWeatherInfo.add(weather.getSunset());
            cityWeatherInfo.add(weather.getWeekDay());
            cityWeatherInfo.add(weather.getDate());
            this.citiesWeatherInfo.add(cityWeatherInfo);
        }
    }

    // Getter
    public ArrayList<ArrayList<String>> getCitiesWeatherInfo() {
        return citiesWeatherInfo;
    }

}


