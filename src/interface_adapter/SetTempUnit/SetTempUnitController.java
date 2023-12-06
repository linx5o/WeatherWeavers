package interface_adapter.SetTempUnit;

import use_case.set_temp_unit.SetTempUnitInputBoundary;

public class SetTempUnitController {
    final SetTempUnitInputBoundary setTempUnitUseCaseInteractor;

    public SetTempUnitController(SetTempUnitInputBoundary setTempUnitUseCaseInteractor) {
        this.setTempUnitUseCaseInteractor = setTempUnitUseCaseInteractor;
    }

    public void execute() {
        setTempUnitUseCaseInteractor.execute();
    }
}
