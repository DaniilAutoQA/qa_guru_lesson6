import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class HomeLambdaAllureTest {
    private static final String BASE_URL = "https://github.com/";
    private static final String REPOSITORY = "/eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    void searchIssues(){
        step("Открываем главную страницу гита", (s) -> {
            s.parameter("url", BASE_URL);
            open(BASE_URL);
        });
        step("Ищем репозиторий" + " " +  REPOSITORY, (s) -> {
            s.parameter("repository", REPOSITORY);
                $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Переходим в репозиторий", (s) -> {
            s.parameter("repository", REPOSITORY);
            $(String.format("[href='%s']", REPOSITORY)).click();
        });
        step("Переходим в Issues", (s) -> {
            s.parameter("repository", REPOSITORY);
            $(String.format("[href='%s/issues']", REPOSITORY)).click();
        });
        step("Проверяем наличие Issues по id", (s) -> {
            s.parameter("id", ISSUE_NUMBER);
            $(withText(String.format("#%s", ISSUE_NUMBER))).should(Condition.exist);
        });
    }
}

