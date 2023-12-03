package data_access;

import entity.Weather;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import use_case.get_other_cities.GetOtherCitiesDataAccessInterface;

import java.time.LocalTime;
import java.util.ArrayList;

public class OtherCitiesDataAccessObject implements GetOtherCitiesDataAccessInterface {
    public static final String API_CONDITIONS = "https://api.aerisapi.com/conditions/";
    private static final String API_TOKEN = System.getenv("API_TOKEN");
    private static final String API_SECRET = System.getenv("API_SECRET");
    public static String getApiToken() {
        return API_TOKEN;
    }

    public OtherCitiesDataAccessObject() {
        // empty constructor
    }
    @Override
    public ArrayList<Weather> fetchWeatherForCities(LocalTime localTime, ArrayList<String> savedCities, Boolean celsius) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        ArrayList<Weather> weatherList = new ArrayList<>();
        for (String city : savedCities) {
            Request request = new Request.Builder()
                    .url(String.format("https://api.aerisapi.com/conditions/%s?format=json&filter=1min&limit=1&client_id=%s&client_secret=%s", city, API_TOKEN, API_SECRET))
                    .build();
            JSONObject responseData;
            try {
                Response response = client.newCall(request).execute();
                System.out.println(response);
                JSONObject responseBody = new JSONObject(response.body().string());

                if (responseBody.getBoolean("success")) {
                    responseData = responseBody.getJSONArray("response").getJSONObject(0);
                    JSONObject period = responseData.getJSONArray("periods").getJSONObject(0);
//                    System.out.println(period);
                    if (celsius) {
                        weatherList.add(new Weather(
                                period.getString("weather"),
                                period.getInt("tempC"),
                                null,
                                null,
                                city,
                                true,
                                null,
                                null,
                                null,
                                null
                        ));
                    } else {
                        weatherList.add(new Weather(
                                period.getString("weather"),
                                period.getInt("tempF"),
                                null,
                                null,
                                city,
                                false,
                                null,
                                null,
                                null,
                                null
                        ));
                    }
                } else {
                    throw new RuntimeException(responseBody.getString("message"));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return weatherList;
    }
}
