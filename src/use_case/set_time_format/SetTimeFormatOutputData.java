package use_case.set_time_format;

public class SetTimeFormatOutputData {

    final private Boolean is24HourFormat;
    final private String message;

    public SetTimeFormatOutputData(Boolean is24HourFormat) {
        this.is24HourFormat = is24HourFormat;
        if (this.is24HourFormat) {
            this.message = "Current time format is 24 hour format.";
        }
        else {
            this.message = "Current time format is 12 hour format.";
        }
    }

    public boolean getIs24HourFormat() {
        return is24HourFormat;
    }

    public String getMessage() {
        return message;
    }
}
