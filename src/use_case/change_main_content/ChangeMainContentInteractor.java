package use_case.change_main_content;

public class ChangeMainContentInteractor implements ChangeMainContentInputBoundary{
    final ChangeMainContentOutputBoundary changeMainContentPresenter;

    public ChangeMainContentInteractor(ChangeMainContentOutputBoundary outputBoundary) {
        this.changeMainContentPresenter = outputBoundary;
    }

    @Override
    public void execute(ChangeMainContentInputData inputData) {
        changeMainContentPresenter.prepareSuccessView(new ChangeMainContentOutputData(inputData.getViewName()));

        // TODO: Fail view?
    }
}
