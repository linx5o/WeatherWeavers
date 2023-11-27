package data_access;

import entity.Weather;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.get_weather.GetWeatherDataAccessInterface;
import okhttp3.*;

import java.io.IOException;
import java.time.LocalDateTime;

public class GetWeatherDataAccessObject implements GetWeatherDataAccessInterface {
    private static final String API_FORECAST = "https://api.aerisapi.com/forecast/";
    private static final String API_CURRENT = "https://api.aerisapi.com/current/";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("API_TOKEN");
    private static final String API_SECRET = System.getenv("API_SECRET");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public GetWeatherDataAccessObject() {
        // empty constructor
    }

    @Override
    public Weather getCityWeather(String city, String date, Boolean celsius) {
        System.out.println(API_TOKEN);
        System.out.println(city);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.aerisapi.com/forecasts/%s?format=json&filter=day&limit=1&client_id=%s&client_secret=%s", city, API_TOKEN, API_SECRET))
                .build();
        JSONObject responseData;

        OkHttpClient client2 = new OkHttpClient().newBuilder()
                .build();
        Request request2 = new Request.Builder()
                .url(String.format("https://api.aerisapi.com/conditions/%s?format=json&filter=1min&limit=1&client_id=%s&client_secret=%s", city, API_TOKEN, API_SECRET))
                .build();
        JSONObject responseData2;

        Double tempMax;
        Double tempMin;
        Double windSpeed;
        Double rainPop;
        String sunriseString;
        String sunsetString;
        Double temp;
        String description;
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getBoolean("success")) {

                JSONArray responses = responseBody.getJSONArray("response");
                JSONObject response1 = responses.getJSONObject(0);
                JSONArray periods = response1.getJSONArray("periods");
                JSONObject period = periods.getJSONObject(0);
                if (celsius) {
                    tempMax = period.getDouble("maxTempC");
                    tempMin = period.getDouble("minTempC");
                } else {
                    tempMax = period.getDouble("maxTempF");
                    tempMin = period.getDouble("minTempF");
                }
                System.out.println(1);
                windSpeed = period.getDouble("windSpeedKPH");
                rainPop = period.getDouble("pop");
                String sunrise = period.getString("sunriseISO");
                String sunset = period.getString("sunsetISO");
                System.out.println(2);
                sunriseString = sunrise.substring(11, 16);
                sunsetString = sunset.substring(11, 16);
            } else {
                throw new RuntimeException(responseBody.getString("error"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }


        try {
            Response response = client2.newCall(request2).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            System.out.println(responseBody);
            if (responseBody.getBoolean("success")) {
                JSONArray responses2 = responseBody.getJSONArray("response");
                JSONObject response2 = responses2.getJSONObject(0);
                JSONArray periods2 = response2.getJSONArray("periods");
                JSONObject period2 = periods2.getJSONObject(0);
                if (celsius) {
                    temp = period2.getDouble("tempC");
                } else {
                    temp = period2.getDouble("tempF");
                }
                System.out.println(3);
                description = period2.getString("weather") + ";" + period2.getString("icon");
            } else {
                throw new RuntimeException(responseBody.getString("error"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
        System.out.println(0);



        System.out.println(2);


        return new Weather(description, (int) Math.round(temp), (int) Math.round(tempMax), (int) Math.round(tempMin), city, celsius, (int) Math.round(windSpeed), (int) Math.round(rainPop), sunriseString, sunsetString);
    }
}
