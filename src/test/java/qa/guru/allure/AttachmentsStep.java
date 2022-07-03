package qa.guru.allure;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsStep {

    @Test
    @Owner("ORomanshchak")
    @Severity(SeverityLevel.MINOR)
    @Feature("Практика с лейбами на тесте с лямбдами")
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://www.film.ru");
        });

        step("Ищем нужный фильм", () -> {
            $("#quick_search_input").setValue("book").pressEnter();
        });

        step("Проверяем, что среди найденных фильмов имеется Green Book", () -> {
            $$("#movies_list").find(text("Green book")).shouldBe(visible);
        });

        step("Переходим на страницу фильма", () -> {
            $(By.cssSelector("#movies_list > a:nth-child(1)")).click();
            attachment("Source", webdriver().driver().source());
            Allure.getLifecycle().addAttachment(
                    "Screenshot", "image/png", "png",
                    ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES)
            );
        });
    }

    @Test
    @Owner("ORomanshchak")
    @Severity(SeverityLevel.MINOR)
    @Feature("Практика с лейбами на тесте с @Step")
    public void searchFilm() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchFilm();
        steps.checkFilm();
        steps.cardFilm();
        steps.takeScreenshot();
    }
}
