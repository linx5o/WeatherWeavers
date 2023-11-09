package use_case.weather;

import java.time.LocalDate;

public class GetWeatherInputData {

    private String city;
    private String date;

    public GetWeatherInputData(String city, String date) {
        this.city = city;
        this.date = date;
    }

    public GetWeatherInputData(String city) {
        this.city = city;
        this.date = LocalDate.now().toString();
    }

    public String getCity() {return city;}

    public String getDate() {return date;}
}
