package use_case.erase_city;

import java.util.ArrayList;

public class EraseCityOutputData {

    final private ArrayList<String> cities;

    public EraseCityOutputData(ArrayList<String> cities) {
        this.cities = cities;
    }

    public ArrayList<String> getCity() {
        return cities;
    }
}
