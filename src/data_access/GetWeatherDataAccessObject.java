package data_access;

import entity.Weather;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.get_weather.GetWeatherDataAccessInterface;
import okhttp3.*;

import java.io.IOException;

public class GetWeatherDataAccessObject implements GetWeatherDataAccessInterface {
    private static final String API_FORECAST = "https://api.aerisapi.com/forecast/";
    private static final String API_CURRENT = "https://api.aerisapi.com/current/";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    @Override
    public Weather getCityWeather(String city, String date, Boolean celsius) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.aerisapi.com/forecast/%s?format=json&filter=day&limit=1&client_id=%s", city, API_TOKEN))
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getBoolean("success")) {
                JSONObject responseData = responseBody.getJSONArray("response").getJSONObject(0);


            } else {
                throw new RuntimeException(responseBody.getString("error"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
