import org.junit.jupiter.api.Test;

public class IssuesExistStepTests {
    WebStep step = new WebStep();
    @Test
    public void VerifyExistIssuesName(){
        step.openHomePage(TestData.BASE_URL);
        step.searchRepository(TestData.REPOSITORY);
        step.goToRepository(TestData.REPOSITORY);
        step.goToTab(TestData.TAB_NAME);
        step.verifyExistIssuesName(TestData.ISSUE_NAME);
    }
}
