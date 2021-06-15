import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssuesExistLambdaTests {

    @Test
    public void VerifyExistIssuesName() {
        step("Открываем главную страницу гита", (s) -> {
            s.parameter("url", TestData.BASE_URL);
            open(TestData.BASE_URL);
            //open(tData.BASE_URL);
        });
        step("Ищем репозиторий", (s) -> {
            s.parameter("ht", TestData.REPOSITORY);
            $(".header-search-input").setValue(TestData.REPOSITORY).pressEnter();
            });
        step("Переходим в репозиторий", (s) -> {
            s.parameter("repository", TestData.REPOSITORY);
            $(String.format("[href='%s']", TestData.REPOSITORY)).click();
        });
        step("Переходим на вкладку Issues", (s) -> {
            s.parameter("tabName", TestData.TAB_NAME);
            $(withText(TestData.TAB_NAME)).click();
        });
        step("Проверяем наличие Issues по названию", (s) ->{
            s.parameter("issues_name", TestData.ISSUE_NAME);
            $(byText(String.format("%s", TestData.ISSUE_NAME))).should(Condition.exist);
        });
    }
}
