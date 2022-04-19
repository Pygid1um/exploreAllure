package com.gitHub;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideTest {

    @BeforeAll
    static void settingsTest() {
        Configuration.browserSize = "1920x1080";
    }

  @Owner("Pygid1um")
  @Severity(SeverityLevel.MINOR)
  @Feature("Тест для репозитория ")
  @Story("Проверка Issue в репозитории")

  @Test
  @DisplayName("Тест на чистом Selenide")
  public void testGithubIssue() {
      SelenideLogger.addListener("allure", new AllureSelenide());

            open("https://github.com");

            $(".header-search-input").click();
            $(".header-search-input").setValue("Pygid1um/exploreAllure").pressEnter();
            $(By.linkText("Pygid1um/exploreAllure")).click();  //клик по ссылке, содержащей текст..
            $(By.partialLinkText("Issues")).click();  //поиск по частичному тексту
            $(withText("#1")).shouldBe(Condition.visible);    //почитай про withText, как именно работает

  }
}
