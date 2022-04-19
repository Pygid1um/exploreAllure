package com.gitHub;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    @BeforeAll
    static void settingsTest() {
        Configuration.browserSize = "1920x1080";
    }

    public static final String testRepository = "Pygid1um/exploreAllure";
    public static final int testIssueNumber = 1;


  @Owner("Pygid1um")
  @Severity(SeverityLevel.BLOCKER)
  @Feature("Тест для репозитория ")
  @Story("Проверка Issue в репозитории")


  @Test
  @DisplayName("Тест с использованием LambdaSteps")
  public void testGithubIssue() {

      SelenideLogger.addListener("allure", new AllureSelenide());
            step("Открытие главной страницы GitHub", () -> {
                open("https://github.com");
            } );


            step("Поиск тестового репозитория " + testRepository, () -> {
                $(".header-search-input").click();
                $(".header-search-input").setValue(testRepository).pressEnter();
            });

            step("Переход по ссылке репозитория " + testRepository, () ->{
                $(By.linkText(testRepository)).click();
            });

            step("Переход во вкладку Issues", () -> {
                $(By.partialLinkText("Issues")).click();
            });

            step("Проверка номера Issue " + testIssueNumber, () -> {
                $(withText("#1")).shouldBe(Condition.visible);

                Allure.getLifecycle().addAttachment(
                        "Исходник тестовой страницы",
                        "text/html",
                        "html",
                        WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
                );
            });

  }
}
