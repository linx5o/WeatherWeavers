package interface_adapater.OtherCities;

import interface_adapter.OtherCities.OtherCitiesController;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import use_case.get_other_cities.GetOtherCitiesInputBoundary;

import java.time.LocalTime;

public class OtherCitiesControllerTest {

    private GetOtherCitiesInputBoundary getOtherCitiesInteractor;
    private OtherCitiesController controller;
    private boolean wasExecuteCalled = false;

    @Before
    public void setUp() {

        // Initialize the mock implementation

        getOtherCitiesInteractor = new GetOtherCitiesInputBoundary() {

            @Override
            public void execute(LocalTime time) {
                wasExecuteCalled = true;
            }
        };

        // Create an instance of OtherCitiesController with the mock

        controller = new OtherCitiesController(getOtherCitiesInteractor);
    }

    @Test
    public void testExecute() {

        // Call the method to test

        controller.execute();

        assertTrue("Execute method should have been called", wasExecuteCalled);
    }

}


