//package data_access;
//
//import entity.Settings;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import org.json.JSONObject;
//import use_case.erase_city.EraseCityDataAccessInterface;
//import use_case.set_city.SetCityDataAccessInterface;
//import use_case.set_default_city.SetDefaultCityDataAccessInterface;
//import use_case.set_temp_unit.SetTempUnitDataAccessInterface;
//import use_case.set_time_format.SetTimeFormatDataAccessInterface;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Objects;
//
//public class ChangeSettingsDataAccessObject implements EraseCityDataAccessInterface, SetCityDataAccessInterface, SetDefaultCityDataAccessInterface, SetTempUnitDataAccessInterface, SetTimeFormatDataAccessInterface {
//    private static final String API_TOKEN = System.getenv("API_TOKEN");
//    private static final String API_SECRET = System.getenv("API_SECRET");
//
//    @Override
//    public Boolean eraseCity(String city) {
//        Settings settings = readSettings();
//        if (settings.getSavedCities().contains(city)) {
//            settings.getSavedCities().remove(city);
//            writeSettings(settings);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public int addCity(String city) {
//        System.out.println(city);
//        Settings settings = readSettings();
//        if (settings.getSavedCities().contains(city)) {
//            return 1;
//        }
//        if (settings.getDefaultCity().equals(city)) {
//            return 2;
//        }
//        if (!isValidCity(city)) {
//            return 3;
//        }
//        if (settings.getSavedCities().size() == 6) {
//            return 4;
//        }
//        settings.getSavedCities().add(city);
//        writeSettings(settings);
//        return 0;
//    }
//
//    @Override
//    public void toggleTempUnit() {
//        Settings settings = readSettings();
//        settings.setCelsius(!settings.getCelsius());
//        writeSettings(settings);
//    }
//
//    @Override
//    public void toggleTimeFormat() {
//        Settings settings = readSettings();
//        settings.setTimeFormat(!settings.getTimeFormat());
//        writeSettings(settings);
//    }
//
//    @Override
//    public Settings getSettings() {
//        return readSettings();
//    }
//
//    @Override
//    public Boolean setDefaultCity(String city) {
//        Settings settings = readSettings();
//        if (settings.getSavedCities().contains(city)) {
//            return false;
//        }
//        if (settings.getDefaultCity().equals(city)) {
//            return false;
//        }
//        if (!isValidCity(city)) {
//            return false;
//        }
//        settings.setDefaultCity(city);
//        writeSettings(settings);
//        return true;
//    }
//
//    private Settings readSettings() {
//        File file = new File("src/app/userpref.txt");
//
//        if (file.exists() && !file.isDirectory()) {
//            // File exists, open and read the file
//            try (FileReader fileReader = new FileReader(file);
//                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
////                System.out.println("File exists, reading file...");
//                String city = bufferedReader.readLine();
//                if (Objects.equals(city, "")) {
//                    throw new IOException("File is empty");
//                }
//                if (!city.matches("^[A-Za-z]+,[A-Za-z]+$")) {
//                    throw new IOException("File is not in the correct format");
//                }
//                Boolean celsius = Boolean.parseBoolean(bufferedReader.readLine());
//                Boolean darkMode = Boolean.parseBoolean(bufferedReader.readLine());
//                Boolean timeFormat = Boolean.parseBoolean(bufferedReader.readLine());
//                String saved = bufferedReader.readLine();
//                ArrayList<String> savedCities = new ArrayList<String>();
//                if (saved != null) {
//                    String[] savedCitiesStr = saved.split(";");
//                    for (String savedCity : savedCitiesStr) {
//                        if (!savedCity.matches("^[A-Za-z]+,[A-Za-z]+$")) {
//                            throw new IOException("File is not in the correct format");
//                        }
//                        savedCities.add(savedCity);
//                    }
//                }
//                return new Settings(celsius, darkMode, timeFormat, city, savedCities);
//
//            } catch (FileNotFoundException e) {
//                System.err.println("File not found: " + e.getMessage());
//            } catch (IOException e) {
//                System.err.println("An error occurred while reading the file: " + e.getMessage());
//            }
//        }
//        // File does not exist, create a new file
//        ArrayList<String> savedCities = new ArrayList<>();
//
//        return new Settings(true, true, true, "", savedCities);
//    }
//
//    private void writeSettings(Settings settings) {
//        File file = new File("src/app/userpref.txt");
//
//        try (FileWriter fileWriter = new FileWriter(file);
//             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
//            bufferedWriter.write(settings.getDefaultCity());
//            bufferedWriter.newLine();
//            bufferedWriter.write(settings.getCelsius().toString());
//            bufferedWriter.newLine();
//            bufferedWriter.write(settings.getDarkMode().toString());
//            bufferedWriter.newLine();
//            bufferedWriter.write(settings.getTimeFormat().toString());
//            bufferedWriter.newLine();
//            bufferedWriter.write(String.join(";", settings.getSavedCities()));
//
//            bufferedWriter.flush();
//        } catch (IOException e) {
//            System.err.println("An error occurred while writing to the file: " + e.getMessage());
//        }
//    }
//
//    private boolean isValidCity(String city) {
//        if (!city.matches("^[A-Za-z]+,[A-Za-z]+$")) {
//            return false;
//        }
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url(String.format("https://api.aerisapi.com/conditions/%s?format=json&filter=1min&limit=1&client_id=%s&client_secret=%s", city, API_TOKEN, API_SECRET))
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//            System.out.println(response);
//            JSONObject responseBody = new JSONObject(response.body().string());
//            return responseBody.getBoolean("success");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
