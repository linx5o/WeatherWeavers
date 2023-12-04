package data_access;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class testCoordinates {

    public static String[] getCoordinates(String city) {
        String apiUrl = "https://nominatim.openstreetmap.org/search?city=" + city + "&format=json";
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(apiUrl);
            String jsonResponse = EntityUtils.toString(httpClient.execute(request).getEntity());
            JSONArray jsonArray = new JSONArray(jsonResponse);

            if (jsonArray.length() > 0) {
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                String lat = jsonObject.getString("lat");
                String lon = jsonObject.getString("lon");
                return new String[]{lat, lon};
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String[] coordinates = getCoordinates("Toronto");
        if (coordinates != null) {
            System.out.println("Latitude: " + coordinates[0] + ", Longitude: " + coordinates[1]);
        } else {
            System.out.println("Coordinates not found.");
        }
    }
}

