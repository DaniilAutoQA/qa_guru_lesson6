import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWebStep {

    @Step("Открываем главную страницу гита")
    public void goToGitHub(){
        open("https://github.com/");
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
    @Step("Проверяем наличие Issues по id {id}")
    public void verifyExistIssuesId(String id){
        $(withText(id)).should(Condition.exist);
    }
}
