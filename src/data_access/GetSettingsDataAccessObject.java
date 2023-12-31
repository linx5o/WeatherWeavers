package data_access;

import entity.Settings;
import entity.Weather;
import use_case.forecast.ForecastDataAccessInterface;
import use_case.forecast.ForecastSettingsDataAccessInterface;
import use_case.get_other_cities.GetOtherCitiesDataAccessInterface;
import use_case.get_other_cities.OtherCitiesSettingsDataAccessInterface;
import use_case.get_weather.GetSettingsDataAccessInterface;
import use_case.get_weather_on_map.GetWeatherOnMapSettingDataAccessInterface;
import use_case.hourly.HourlySettingsDataAccessInterface;
import use_case.humidity.HumiditySettingDataAccessInterface;
import use_case.settings_start.SettingsDataAccessInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class GetSettingsDataAccessObject implements GetSettingsDataAccessInterface, HourlySettingsDataAccessInterface, ForecastSettingsDataAccessInterface, OtherCitiesSettingsDataAccessInterface, GetWeatherOnMapSettingDataAccessInterface, HumiditySettingDataAccessInterface, SettingsDataAccessInterface {
    @Override
    public Settings getSettings() {
        File file = new File("src/app/userpref.txt");

        if (file.exists() && !file.isDirectory()) {
            // File exists, open and read the file
            try (FileReader fileReader = new FileReader(file);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//                System.out.println("File exists, reading file...");
                String city = bufferedReader.readLine();
                if (Objects.equals(city, "")) {
                    throw new IOException("File is empty");
                }
                if (!city.matches("^[A-Za-z]+,[A-Za-z]+$")) {
                    throw new IOException("File is not in the correct format");
                }
                Boolean celsius = Boolean.parseBoolean(bufferedReader.readLine());
                Boolean darkMode = Boolean.parseBoolean(bufferedReader.readLine());
                Boolean timeFormat = Boolean.parseBoolean(bufferedReader.readLine());
                String saved = bufferedReader.readLine();
                ArrayList<String> savedCities = new ArrayList<String>();
                if (saved != null) {
                    String[] savedCitiesStr = saved.split(";");
                    for (String savedCity : savedCitiesStr) {
                        if (!savedCity.matches("^[A-Za-z]+,[A-Za-z]+$")) {
                            throw new IOException("File is not in the correct format");
                        }
                        savedCities.add(savedCity);
                    }
                }
                return new Settings(celsius, darkMode, timeFormat, city, savedCities);

            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("An error occurred while reading the file: " + e.getMessage());
            }
        }
        // File does not exist, create a new file
        ArrayList<String> savedCities = new ArrayList<>();

        return new Settings(true, true, true, "toronto,ca", savedCities);
    }
}
