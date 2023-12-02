package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import use_case.hourly.HourlyDataAccessInterface;
import java.time.LocalTime;
import java.util.ArrayList;

public class HourlyDataAccessObject implements HourlyDataAccessInterface {
    public static final String API_CONDITIONS = "https://api.aerisapi.com/conditions/";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("API_TOKEN");
    private static final String API_SECRET = System.getenv("API_SECRET");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public HourlyDataAccessObject() {
        // empty constructor
    }

    @Override
    public ArrayList<LocalTime> getHours(String city, LocalTime localTime) {
        ArrayList<LocalTime> times = new ArrayList<>();
        LocalTime nextHour = localTime.getMinute() == 0 ? localTime : localTime.plusHours(1).withMinute(0).withSecond(0).withNano(0);

        for (int i = 0; i < 10; i=i+2) {
            times.add(nextHour.plusHours(i));
        }
        return times;
    }

    @Override
    public ArrayList<Integer> getTemps(String city, LocalTime localTime, Boolean celsius) {
//        System.out.println(localTime);
        LocalTime nextHour = localTime.getMinute() == 0 ? localTime : localTime.plusHours(1).withMinute(0).withSecond(0).withNano(0);
        LocalTime nextHourPlusFive = nextHour.plusHours(10);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.aerisapi.com/forecasts/%s?format=json&filter=1hr&from=%s&to=%s&client_id=%s&client_secret=%s", city, nextHour, nextHourPlusFive, API_TOKEN, API_SECRET))
                .build();
        JSONObject responseData;

        ArrayList<Integer> temps = new ArrayList<>();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getBoolean("success")) {
                responseData = responseBody.getJSONArray("response").getJSONObject(0);
                if (celsius) {
                    for (int i = 0; i < 10; i=i+2) {
                        JSONObject period = responseData.getJSONArray("periods").getJSONObject(i);
//                        System.out.println(period);
                        temps.add(period.getInt("tempC"));
                    }
                } else {
                    for (int i = 0; i < 10; i=i+2) {
                        JSONObject period = responseData.getJSONArray("periods").getJSONObject(i);
                        temps.add(period.getInt("tempF"));
                    }
                }
                return temps;
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
