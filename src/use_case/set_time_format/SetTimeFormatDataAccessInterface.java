package use_case.set_time_format;

import entity.Settings;

public interface SetTimeFormatDataAccessInterface {

    void toggleTimeFormat();

    Settings getSettings();
}
