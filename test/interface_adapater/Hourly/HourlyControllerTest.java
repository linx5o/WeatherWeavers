package interface_adapater.Hourly;

import interface_adapter.Hourly.HourlyController;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import use_case.hourly.HourlyInputBoundary;
import use_case.hourly.HourlyInputData;

import java.time.LocalTime;

public class HourlyControllerTest {

    private HourlyInputBoundary hourlyInteractor;
    private HourlyController controller;
    private boolean wasExecuteCalled = false;

    @Before
    public void setUp() {

        // Initialize the mock implementation

       hourlyInteractor = new HourlyInputBoundary() {

           @Override
           public void execute(HourlyInputData hourlyInputData) {
               wasExecuteCalled = true;
           }

           @Override
           public void execute(LocalTime localTime) {
               wasExecuteCalled = true;
           }

       };

        // Create an instance of OtherCitiesController with the mock

        controller = new HourlyController(hourlyInteractor);
    }

    @Test
    public void testExecute() {

        // Call the method to test

        controller.execute();

        assertTrue("Execute method should have been called", wasExecuteCalled);
    }

}