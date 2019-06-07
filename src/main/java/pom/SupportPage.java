package pom;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SupportPage extends BasePage {
    public void search(String searchTerm) {
        $(By.id("query")).shouldBe(visible).setValue(searchTerm).pressEnter();
    }
}
