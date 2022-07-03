package qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void testSearchFilm () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://www.film.ru");
        $("#quick_search_input").setValue("book").pressEnter();
        $$("#movies_list").find(text("Green book")).shouldBe(visible);
        $(By.cssSelector("#movies_list > a:nth-child(1)")).click();


    }
}
