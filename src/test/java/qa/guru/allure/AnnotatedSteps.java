package qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AnnotatedSteps {

    @Test
    @Tag("telega")
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
    }
}
