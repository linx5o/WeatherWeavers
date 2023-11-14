package use_case.get_weather;

import entity.Weather;
import java.time.LocalDate;

public class GetWeatherInputData {

    final private String city;
    final private String date;

    public GetWeatherInputData(String city) {
        this.city = city;
        this.date = LocalDate.now().toString();
    }

    public String getCity() {return city;}

    public String getDate() {return date;}
}
