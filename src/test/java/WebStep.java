import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebStep {

    @Step("Открываем главную страницу гита")
    public void openHomePage(String url){
        open(url);
    }
    @Step("Ищем репозиторий {repository}")
    public void searchRepository(String repository){
        $(".header-search-input").setValue(repository).pressEnter();
    }
    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository){
        $(String.format("[href='%s']",repository )).click();
    }
    @Step("Переходим на вкладку {tabName}")
    public void goToTab(String tabName){
        $(withText(tabName)).click();
    }
    @Step("Проверяем наличие Issues по названию {name}")
    public void verifyExistIssuesName(String name){
        $(byText(String.format("%s", name))).should(Condition.exist);
    }


}
