import org.junit.jupiter.api.Test;

public class HomeAnnotatedStepTests {
    HomeWebStep step = new HomeWebStep();

    @Test
    public void annotatedTest(){
        step.goToGitHub();
        step.searchRepository("eroshenkoam/allure-example");
        step.goToRepository("/eroshenkoam/allure-example");
        step.goToTab("Issues");
        step.verifyExistIssuesId("#68");
    }
}
