package interface_adapter.Hourly;

import interface_adapter.Hourly.HourlyState;
import interface_adapter.Hourly.HourlyViewModel;
import use_case.hourly.HourlyOutputBoundary;
import use_case.hourly.HourlyOutputData;

import java.time.format.DateTimeFormatter;

public class HourlyPresenter implements HourlyOutputBoundary {
    final private HourlyViewModel hourlyViewModel;
    public HourlyPresenter(HourlyViewModel hourlyViewModel) {
        this.hourlyViewModel = hourlyViewModel;
    }

    @Override
    public void prepareSuccessView(HourlyOutputData hourlyOutputData) {
        HourlyState state = hourlyViewModel.getState();
        state.setTemp1(hourlyOutputData.getTemps().get(0).toString() + "°");
        state.setTemp2(hourlyOutputData.getTemps().get(1).toString() + "°");
        state.setTemp3(hourlyOutputData.getTemps().get(2).toString() + "°");
        state.setTemp4(hourlyOutputData.getTemps().get(3).toString() + "°");
        state.setTemp5(hourlyOutputData.getTemps().get(4).toString() + "°");
        if (hourlyOutputData.getTimeFormat()) {
            state.setTime1(hourlyOutputData.getHours().get(0).format(DateTimeFormatter.ofPattern("HH:mm")));
            state.setTime2(hourlyOutputData.getHours().get(1).format(DateTimeFormatter.ofPattern("HH:mm")));
            state.setTime3(hourlyOutputData.getHours().get(2).format(DateTimeFormatter.ofPattern("HH:mm")));
            state.setTime4(hourlyOutputData.getHours().get(3).format(DateTimeFormatter.ofPattern("HH:mm")));
            state.setTime5(hourlyOutputData.getHours().get(4).format(DateTimeFormatter.ofPattern("HH:mm")));
        } else {
            state.setTime1(hourlyOutputData.getHours().get(0).format(DateTimeFormatter.ofPattern("hh:mm a")));
            state.setTime2(hourlyOutputData.getHours().get(1).format(DateTimeFormatter.ofPattern("hh:mm a")));
            state.setTime3(hourlyOutputData.getHours().get(2).format(DateTimeFormatter.ofPattern("hh:mm a")));
            state.setTime4(hourlyOutputData.getHours().get(3).format(DateTimeFormatter.ofPattern("hh:mm a")));
            state.setTime5(hourlyOutputData.getHours().get(4).format(DateTimeFormatter.ofPattern("hh:mm a")));
        }
        hourlyViewModel.setState(state);
        hourlyViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // TODO: implement
    }
}
