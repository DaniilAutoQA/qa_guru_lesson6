import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssuesExistSelenideTests {
    @Test
    public void VerifyExistIssuesName(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(TestData.BASE_URL);
        $(".header-search-input").setValue(TestData.REPOSITORY).pressEnter();
        $(String.format("[href='%s']", TestData.REPOSITORY)).click();
        $(String.format("[href='%s/issues']", TestData.REPOSITORY)).click();
        $(byText(String.format("%s", TestData.ISSUE_NAME))).should(Condition.visible);
    }
}
