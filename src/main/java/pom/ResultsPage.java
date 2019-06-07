package pom;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ResultsPage extends BasePage {
    public void select(String requiredResult) {
        Actions actions = new Actions(getWebDriver());
        ElementsCollection results = $$(By.cssSelector("a.search-result-link")).shouldHave(CollectionCondition.sizeGreaterThan(0));
        for(SelenideElement result : results) {
            if ( result.isEnabled() && result.innerText().contentEquals(requiredResult) ) {
                actions.click(result).build().perform();
                break;
            }
        }

        new WebDriverWait(getWebDriver(), 20).until(
                d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));

    }

    public void javaSelect(String requiredResult) {
        new WebDriverWait(getWebDriver(), 20).until(
                d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
        String thisUrl = url();
        ElementsCollection results = $$(By.cssSelector("a.search-result-link"));
        for(SelenideElement result : results) {
            if ( result.isEnabled() && result.innerText().contentEquals(requiredResult) ) {
                JavascriptExecutor executor = (JavascriptExecutor)getWebDriver(); executor.executeScript("arguments[0].click();", result);
                break;
            }
        }

        new WebDriverWait(getWebDriver(), 20).until(
                d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));

    }
}
