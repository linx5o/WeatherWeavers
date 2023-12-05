package use_case.set_city;

import java.util.ArrayList;

public class SetCityOutputData {

//        final private String city;
        final private ArrayList<String> cities;

        public SetCityOutputData(ArrayList<String> cities) {
//            this.city = city;
            this.cities = cities;
        }

//        public String getCity() {
//            return city;
//        }

        public ArrayList<String> getCity() {
            return cities;
        }

}
