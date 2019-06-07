package pom;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ArticlesPage extends BasePage {
    public void selectArticle(String requiredArticle) {
        ElementsCollection results = $$(By.cssSelector("div.article-body table td a"));
        for(SelenideElement result : results) {
            String i = result.innerText();
            Boolean b = i.contains(requiredArticle.trim());
            if ( b ) {
                JavascriptExecutor executor = (JavascriptExecutor)getWebDriver(); executor.executeScript("arguments[0].click();", result);
                break;
            }
        }
    }
}
