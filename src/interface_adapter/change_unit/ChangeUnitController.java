package interface_adapter.change_unit;
import entity.TemperatureUnit;
import use_case.change_unit.ChangeUnitInputBoundary;
import use_case.change_unit.ChangeUnitInputData;
public class ChangeUnitController {
    private final ChangeUnitInputBoundary interactor;

    public ChangeUnitController(ChangeUnitInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void changeUnit(TemperatureUnit.Unit unit) {
        ChangeUnitInputData inputData = new ChangeUnitInputData(unit);
        interactor.changeTemperatureUnit(inputData.getUnit());
    }
}
