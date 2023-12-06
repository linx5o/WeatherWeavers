package use_case.change_main_content;

import org.junit.Before;
import org.junit.Test;

public class ChangeMainContentInteractorTest {

    private ChangeMainContentOutputBoundary changeMainContentPresenter;
    private String viewName;

    @Before
    public void setUp() {
        changeMainContentPresenter = new ChangeMainContentOutputBoundary() {
            @Override
            public void prepareSuccessView(ChangeMainContentOutputData outputData) {
                viewName = outputData.getViewName();
            }
        };
    }

    @Test
    public void testExecute() {
        ChangeMainContentInputData inputData = new ChangeMainContentInputData("viewName");
        ChangeMainContentInteractor changeMainContentInteractor = new ChangeMainContentInteractor(changeMainContentPresenter);
        changeMainContentInteractor.execute(inputData);
        assert viewName.equals("viewName");
    }

}
