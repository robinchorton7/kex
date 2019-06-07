package pom;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FuturesDashboardPage extends BasePage {
    public boolean pageTitle(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 30);
        boolean result = wait.until(ExpectedConditions.titleContains(expectedTitle));
        return result;
    }
}
