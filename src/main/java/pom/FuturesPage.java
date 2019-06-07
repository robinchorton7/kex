package pom;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import static com.codeborne.selenide.Selenide.open;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FuturesPage extends BasePage {

    public BasePage gotoPage(String buttonText) {
        ElementsCollection anchors = $$(By.cssSelector("a"));
        for(SelenideElement anchor : anchors) {
            if ( anchor.innerText().contentEquals(buttonText) ) {
                // get the redirected url
                String redirectedUrl = anchor.getAttribute("to");
                open(redirectedUrl);
                break;
            }
        }
        return page(SupportPage.class);
    }
}
