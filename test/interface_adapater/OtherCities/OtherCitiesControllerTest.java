package interface_adapater.OtherCities;
import interface_adapter.OtherCities.OtherCitiesController;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import use_case.get_other_cities.GetOtherCitiesInputBoundary;

import java.time.LocalTime;

public class OtherCitiesControllerTest {

    private MockGetOtherCitiesInputBoundary mockInputBoundary;
    private OtherCitiesController controller;

    @Before
    public void setUp() {

        // Initialize the mock implementation

        mockInputBoundary = new MockGetOtherCitiesInputBoundary();

        // Create an instance of OtherCitiesController with the mock

        controller = new OtherCitiesController(mockInputBoundary);
    }

    @Test
    public void testExecute() {

        // Call the method to test

        controller.execute();

        assertTrue("Execute method should have been called", mockInputBoundary.wasExecuteCalled());
    }

    // Mock implementation of GetOtherCitiesInputBoundary

    private static class MockGetOtherCitiesInputBoundary implements GetOtherCitiesInputBoundary {
        private boolean executeCalled = false;

        @Override
        public void execute(LocalTime time) {
            this.executeCalled = true;
        }

        public boolean wasExecuteCalled() {
            return executeCalled;
        }
    }
}


