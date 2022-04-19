package com.gitHub;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AnnotatedStepsTest {

    @BeforeAll
    static void settingsTest() {
        Configuration.browserSize = "1920x1080";
    }

    public static final String testRepository = "Pygid1um/exploreAllure";
    public static final int testIssueNumber = 1;

  @Owner("Pygid1um")
  @Severity(SeverityLevel.CRITICAL)
  @Feature("Тест для репозитория ")
  @Story("Проверка Issue в репозитории")

  @Test
  @DisplayName("Тест с использованием аннотации @Step")
  public void testGithubIssue() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(testRepository);
        steps.clickOnRepositoryLink(testRepository);
        steps.openIssuesTab();
        steps.checkIssueNumber(testIssueNumber);

  }
}
