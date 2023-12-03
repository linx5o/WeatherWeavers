package use_case.set_temp_unit;

public class SetTempUnitInteractor implements SetTempUnitInputBoundary{

    final SetTempUnitOutputBoundary setTempUnitPresenter;
    final SetTempUnitDataAccessInterface setTempUnitDataAccessObject;

    public SetTempUnitInteractor(SetTempUnitOutputBoundary setTempUnitPresenter, SetTempUnitDataAccessInterface setTempUnitDataAccessObject) {
        this.setTempUnitPresenter = setTempUnitPresenter;
        this.setTempUnitDataAccessObject = setTempUnitDataAccessObject;
    }

    @Override
    public void execute() {
        setTempUnitDataAccessObject.toggleTempUnit();
        SetTempUnitOutputData setTempUnitOutputData = new SetTempUnitOutputData(setTempUnitDataAccessObject.getSettings().getCelsius());
        setTempUnitPresenter.prepareSuccessView(setTempUnitOutputData);
    }
}
