package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertFalse;

public class BasePage {

    public boolean pageTitle(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 30);
        boolean result = wait.until(ExpectedConditions.titleIs(expectedTitle));
        return result;
    }

    public void clickButton(String buttonText) {
        ElementsCollection anchors = $$(byXpath("//a[contains(text(),'" + buttonText + "')]"));

        for(SelenideElement anchor : anchors) {
            scrollToElement(anchor);
            if ( anchor.is(visible)) {
                anchor.click();
                break;
            }
        }
    }

    void scrollToElement( SelenideElement element) {
        JavascriptExecutor jse2 = (JavascriptExecutor)getWebDriver();
        jse2.executeScript("arguments[0].scrollIntoView()", element);
    }
}
