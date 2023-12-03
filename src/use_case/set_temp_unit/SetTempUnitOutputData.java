package use_case.set_temp_unit;

public class SetTempUnitOutputData {

    final private boolean isCelsius;
    final private String message;

    public SetTempUnitOutputData(boolean isCelsius) {
        this.isCelsius = isCelsius;
        if (isCelsius) {
            this.message = "Current temperature unit is Celsius";
        }
        else {
            this.message = "Current temperature unit is Fahrenheit";
        }
    }

    public boolean isCelsius() {
        return isCelsius;
    }

    public String getMessage() {
        return message;
    }
}
