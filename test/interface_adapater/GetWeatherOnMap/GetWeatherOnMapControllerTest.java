package interface_adapater.GetWeatherOnMap;

import interface_adapter.GetWeatherOnMap.GetWeatherOnMapController;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import use_case.get_weather_on_map.GetWeatherOnMapInputBoundary;
import use_case.get_weather_on_map.GetWeatherOnMapInputData;

public class GetWeatherOnMapControllerTest {

    private MockGetWeatherOnMapInteractor mockInteractor;
    private GetWeatherOnMapController controller;

    @Before
    public void setUp() {

        // Initialize the mock implementation

        mockInteractor = new MockGetWeatherOnMapInteractor();

        // Create an instance of HumidityController with the mock

        controller = new GetWeatherOnMapController(mockInteractor);
    }

    @Test
    public void testExecute() {

        // Call the method to test

        controller.execute();

        assertTrue("Execute method should have been called", mockInteractor.wasExecuteCalled());
    }

    // Mock implementation of HumidityInputBoundary

    private static class MockGetWeatherOnMapInteractor implements GetWeatherOnMapInputBoundary {
        private boolean executeCalled = false;

        public boolean wasExecuteCalled() {
            return executeCalled;
        }

        @Override
        public void execute(GetWeatherOnMapInputData getWeatherOnMapInputData) {
            this.executeCalled = true;
        }

    }
}