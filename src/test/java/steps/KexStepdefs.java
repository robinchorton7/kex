package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pom.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class KexStepdefs {
    public KexHomePage kexHomePage;
    public FuturesPage futuresPage;
    public SupportPage supportPage;
    public BasePage genericPage = new BasePage();

    @Given("^I am on the \"([^\"]*)\" home page$")
    public void iAmOnTheHomePage(String url){
        kexHomePage = open(url, KexHomePage.class);
    }

    @When("^I select \"([^\"]*)\"$")
    public void iSelect(String buttonText) {
        genericPage.clickButton(buttonText);
    }

    @Then("^the \"([^\"]*)\" page is displayed$")
    public void thePageIsDisplayed(String expectedTitle){
        assertTrue(genericPage.pageTitle(expectedTitle));
    }

    @And("^I enter \"([^\"]*)\" into the search input box$")
    public void iEnterIntoTheSearchInputBox(String searchTerm) {
        supportPage.search(searchTerm);
    }

    @And("^When I goto the \"([^\"]*)\" page$")
    public void whenIGotoThePage(String buttonText) {
        futuresPage = new FuturesPage();
        supportPage = (SupportPage) futuresPage.gotoPage(buttonText);
    }

    @And("^I choose \"([^\"]*)\"$")
    public void iChoose(String language) {
        kexHomePage.chooseLanguage(language);
    }

    @And("^I pick \"([^\"]*)\"$")
    public void iPick(String result) {
        ResultsPage resultsPage = new ResultsPage();
        resultsPage.select(result);
    }

    @And("^I select article \"([^\"]*)\"$")
    public void iSelectArticle(String article) {
        ArticlesPage articlesPage = new ArticlesPage();
        articlesPage.selectArticle(article);
    }

    @Then("^the futures dashboard page with title containing \"([^\"]*)\" is displayed$")
    public void theFuturesDashboardPageWithTitleContainingIsDisplayed(String expectedTitle) throws Throwable {
        FuturesDashboardPage futuresDashBoardPage = new FuturesDashboardPage();
        assertTrue(futuresDashBoardPage.pageTitle(expectedTitle));
    }
}
