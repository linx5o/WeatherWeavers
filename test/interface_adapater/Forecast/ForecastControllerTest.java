package interface_adapater.Forecast;
import interface_adapter.Forecast.ForecastController;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import use_case.forecast.ForecastInputBoundary;
import use_case.forecast.ForecastInputData;

public class ForecastControllerTest {

    private MockForecastInputBoundary mockInputBoundary;
    private ForecastController controller;

    @Before
    public void setUp() {

        // Initialize the mock implementation

        mockInputBoundary = new MockForecastInputBoundary();

        // Create an instance of HumidityController with the mock

        controller = new ForecastController(mockInputBoundary);
    }

    @Test
    public void testExecute() {

        // Call the method to test

        controller.execute(1, true);

        assertTrue("Execute method should have been called", mockInputBoundary.wasExecuteCalled());
    }

    // Mock implementation of HumidityInputBoundary

    private static class MockForecastInputBoundary implements ForecastInputBoundary {
        private boolean executeCalled = false;

        public boolean wasExecuteCalled() {
            return executeCalled;
        }

        @Override
        public void execute(ForecastInputData forecastInputData) {
            this.executeCalled = true;
        }

        @Override
        public void execute(int days, boolean information) {
            this.executeCalled = true;
        }
    }
}
