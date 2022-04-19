package com.gitHub;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открытие главной страницы GitHub")
    public void openMainPage() {

        open("https://github.com");
    }

    @Step("Поиск тестового репозитория {repository}")
    public void searchForRepository(String repository) {

        $(".header-search-input").click();
        $(".header-search-input").setValue(repository).pressEnter();
    }

    @Step("Переход по ссылке репозитория {repository}")
    public void clickOnRepositoryLink(String repository) {

        $(By.linkText(repository)).click();
    }

    @Step("Переход во вкладку Issues")
    public void openIssuesTab() {

        $(By.partialLinkText("Issues")).click();
    }

    @Step("Проверка номера Issue {number}")
    public void checkIssueNumber(int issueNumber) {
        $(withText("#" + issueNumber)).shouldBe(Condition.visible);
        attachScreenshot();
    }

    @Attachment(value = "Добавил скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {

        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
