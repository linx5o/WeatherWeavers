package use_case.set_temp_unit;

import entity.Settings;

public interface SetTempUnitDataAccessInterface {

    void toggleTempUnit();

    Settings getSettings();
}
