//package use_case.change_unit;
//import entity.TemperatureUnit;
//
//
//public class ChangeUnitInteractor implements ChangeUnitInputBoundary {
//    private final ChangeUnitDataAccessInterface dataAccess;
//
//    public ChangeUnitInteractor(ChangeUnitDataAccessInterface dataAccess) {
//        this.dataAccess = dataAccess;
//    }
//
//    @Override
//    public void changeTemperatureUnit(TemperatureUnit.Unit unit) {
//        TemperatureUnit temperatureUnit = dataAccess.getTemperatureUnit();
//        temperatureUnit.setCurrentUnit(unit);
//        dataAccess.saveTemperatureUnit(temperatureUnit);
//    }
//}
//
