package pom;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class KexHomePage extends BasePage {

    public void chooseLanguage(String language) {
        SelenideElement languageSelect = $(By.id("curlang"));// need to scroll button into viewport
        super.scrollToElement(languageSelect);
        $(By.id("curlang")).selectOption(language);
    }
}
