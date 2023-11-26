package use_case.get_other_cities;

import java.time.LocalTime;

public interface GetOtherCitiesInputBoundary {
    void execute(LocalTime localTime);
}
