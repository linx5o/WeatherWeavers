package use_case.change_unit;
import entity.TemperatureUnit;

public interface ChangeUnitInputBoundary {
    void changeTemperatureUnit(TemperatureUnit.Unit unit);
}
