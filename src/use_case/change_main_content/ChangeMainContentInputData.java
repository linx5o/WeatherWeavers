package use_case.change_main_content;

public class ChangeMainContentInputData {
    private final String viewName;

    public ChangeMainContentInputData(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {return viewName;}
}
