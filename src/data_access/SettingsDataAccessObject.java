package data_access;

import entity.Settings;
import use_case.settings_start.SettingsDataAccessInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class SettingsDataAccessObject implements SettingsDataAccessInterface {

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
                String[] savedCitiesStr = bufferedReader.readLine().split(";");
                ArrayList<String> savedCities = new ArrayList<String>();
                for (String savedCity : savedCitiesStr) {
                    if (!savedCity.matches("^[A-Za-z]+,[A-Za-z]+$")) {
                        throw new IOException("File is not in the correct format");
                    }
                    savedCities.add(savedCity);
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

        return new Settings(true, true, true, "", savedCities);
    }
}
