package data_access;

import entity.Location;
import entity.Weather;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.forecast.ForecastDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ForecastDataAccessObject implements ForecastDataAccessInterface {
    public static final String API_FORECAST = "https://api.aerisapi.com/forecast/";

    public static final String API_TOKEN = System.getenv("API_TOKEN");
    public static final String API_SECRET = System.getenv("API_SECRET");

    public static String getApiToken() {
        return API_TOKEN;
    }
    public ForecastDataAccessObject() {
        // empty constructor
    }
    @Override
    public List<Weather> getForecast(String city, int days, Boolean isCelsius) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.aerisapi.com/forecasts/%s?format=json&filter=day&limit=%d&client_id=%s&client_secret=%s", city, days, API_TOKEN, API_SECRET))
                .build();
        JSONObject responseData;

        List<Weather> weatherList = new ArrayList<>();

        try {
            Response response = client.newCall(request).execute();
            responseData = new JSONObject(response.body().string());
            if (responseData.getBoolean("success")) {
                JSONArray responseArray = responseData.getJSONArray("response").getJSONObject(0).getJSONArray("periods");
                System.out.println(responseArray);
                for (int i = 0; i < responseArray.length(); i++) {
                    JSONObject period = responseArray.getJSONObject(i);
                    if (isCelsius) {
                        weatherList.add(new Weather(
                                period.getString("weather") + ";" + period.getString("icon"),
                                null,
                                period.getInt("maxTempC"),
                                period.getInt("minTempC"),
                                city,
                                true,
                                period.getInt("windSpeedKPH"),
                                period.getInt("pop"),
                                period.getString("sunriseISO"),
                                period.getString("sunsetISO")
                        ));
                    } else {
                        weatherList.add(new Weather(
                                period.getString("weather") + ";" + period.getString("icon"),
                                null,
                                period.getInt("maxTempF"),
                                period.getInt("minTempF"),
                                city,
                                false,
                                period.getInt("windSpeedKPH"),
                                period.getInt("pop"),
                                period.getString("sunriseISO"),
                                period.getString("sunsetISO")
                        ));
                    }
                }
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

        System.out.println(weatherList);
        return weatherList;
    }
}
