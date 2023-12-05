package interface_adapater.GetWeather;
import interface_adapter.Humidity.HumidityController;
import interface_adapter.OtherCities.OtherCitiesController;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import use_case.get_other_cities.GetOtherCitiesInputBoundary;
import use_case.get_weather.GetWeatherInputBoundary;
import use_case.humidity.HumidityInputBoundary;
import use_case.humidity.HumidityInputData;

import java.time.LocalTime;

public class HumidityControllerTest {

    private MockHumidityInputBoundary mockInputBoundary;
    private HumidityController controller;

    @Before
    public void setUp() {

        // Initialize the mock implementation

        mockInputBoundary = new MockHumidityInputBoundary();

        // Create an instance of HumidityController with the mock

        controller = new HumidityController(mockInputBoundary);
    }

    @Test
    public void testExecute() {

        // Call the method to test

        controller.execute();

        assertTrue("Execute method should have been called", mockInputBoundary.wasExecuteCalled());
    }

    // Mock implementation of HumidityInputBoundary

    private static class MockHumidityInputBoundary implements HumidityInputBoundary {
        private boolean executeCalled = false;

        @Override
        public void execute(HumidityInputData humidityInputData) {
            this.executeCalled = true;
        }

        @Override
        public void execute(LocalTime localTime) {
            this.executeCalled = true;
        }

        public boolean wasExecuteCalled() {
            return executeCalled;
        }
    }
}
