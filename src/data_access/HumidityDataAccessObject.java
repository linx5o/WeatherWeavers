package data_access;

import entity.Humidity;
import use_case.humidity.HumidityDataAccessInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import okhttp3.*;

import java.io.IOException;

public class HumidityDataAccessObject implements HumidityDataAccessInterface {
    public static final String API_CONDITIONS = "https://api.aerisapi.com/conditions/";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("API_TOKEN");
    private static final String API_SECRET = System.getenv("API_SECRET");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public HumidityDataAccessObject() {
        // empty constructor
    }

    @Override
    public Humidity getHumidity(String city, String date) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.aerisapi.com/conditions/%s?format=json&filter=1min&limit=1&client_id=%s&client_secret=%s", city, API_TOKEN, API_SECRET))
                .build();
        JSONObject responseData;

        Double humidity;

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getBoolean("success")) {
                responseData = responseBody.getJSONArray("response").getJSONObject(0);
                JSONObject period = responseData.getJSONArray("periods").getJSONObject(0);
                humidity = period.getDouble("humidity");
                if (humidity >= 99.5) {
                    humidity = 99.0;
                }
                return new Humidity((int) Math.round(humidity));
                } else {
                    throw new RuntimeException(responseBody.getString("message"));
                }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
