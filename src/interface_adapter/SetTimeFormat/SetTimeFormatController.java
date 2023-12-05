package interface_adapter.SetTimeFormat;

import use_case.set_time_format.SetTimeFormatInputBoundary;

public class SetTimeFormatController {
    final SetTimeFormatInputBoundary setTimeFormatUseCaseInteractor;

    public SetTimeFormatController(SetTimeFormatInputBoundary setTimeFormatUseCaseInteractor) {
        this.setTimeFormatUseCaseInteractor = setTimeFormatUseCaseInteractor;
    }

    public void execute() {
        setTimeFormatUseCaseInteractor.execute();
    }
}
