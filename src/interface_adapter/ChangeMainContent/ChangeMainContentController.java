package interface_adapter.ChangeMainContent;

import use_case.change_main_content.ChangeMainContentInputBoundary;
import use_case.change_main_content.ChangeMainContentInputData;

public class ChangeMainContentController {
    final ChangeMainContentInputBoundary changeMainContentUseCaseInteractor;

    public ChangeMainContentController(ChangeMainContentInputBoundary changeMainContentUseCaseInteractor) {
        this.changeMainContentUseCaseInteractor = changeMainContentUseCaseInteractor;
    }

    public void execute(String city) {
        changeMainContentUseCaseInteractor.execute(new ChangeMainContentInputData(city));
    }
}
