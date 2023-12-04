package use_case.change_main_content;

public class ChangeMainContentOutputData {
    private final String viewName;

    public ChangeMainContentOutputData(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }
}
