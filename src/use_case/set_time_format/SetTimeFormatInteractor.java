package use_case.set_time_format;

public class SetTimeFormatInteractor implements SetTimeFormatInputBoundary {

    final SetTimeFormatDataAccessInterface setTimeFormatDataAccessObject;
    final SetTimeFormatOutputBoundary setTimeFormatPresenter;

    public SetTimeFormatInteractor(SetTimeFormatDataAccessInterface setTimeFormatDataAccessObject, SetTimeFormatOutputBoundary setTimeFormatPresenter) {
        this.setTimeFormatDataAccessObject = setTimeFormatDataAccessObject;
        this.setTimeFormatPresenter = setTimeFormatPresenter;
    }

    @Override
    public void execute() {
        setTimeFormatDataAccessObject.toggleTimeFormat();
        SetTimeFormatOutputData setTimeFormatOutputData = new SetTimeFormatOutputData(setTimeFormatDataAccessObject.getSettings().getTimeFormat());
        setTimeFormatPresenter.prepareSuccessView(setTimeFormatOutputData);
    }
}
