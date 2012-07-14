package org.richfaces.tests.components.objects;

import static org.richfaces.tests.components.autocomplete.AutocompleteComponentImpl.CLASS_NAME_SUGGESTION_LIST;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.graphene.spi.components.autocomplete.ClearType;
import org.jboss.arquillian.graphene.spi.components.autocomplete.Suggestion;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.richfaces.tests.components.AbstractTest;
import org.richfaces.tests.components.autocomplete.AutocompleteComponentImpl;
import org.richfaces.tests.components.autocomplete.StringSuggestionParserImpl;
import org.richfaces.tests.components.autocomplete.SuggestionImpl;
import org.richfaces.tests.components.objects.bean.Person;
import org.richfaces.tests.components.objects.bean.PersonBean;
import org.testng.annotations.Test;

public class TestAutocompleteComponent extends AbstractTest {

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return createDeployment(TestAutocompleteComponent.class).addClass(PersonBean.class).addClass(Person.class);
    }

    @FindBy(xpath = "//*[contains(@id,'autocomplete')]")
    private AutocompleteComponentImpl<String> autocompleteComponent;

    // @FindBy(xpath = "//*[contains(@id,'autocomplete2')]")
    // private AutocompleteComponentImpl<String> autocompleteComponent2;

    @FindBy(className = CLASS_NAME_SUGGESTION_LIST)
    WebElement suggestionList1;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    WebElement inputToWrite;

    // @FindBy(xpath = "(//input[@type='text'])[2]")
    // WebElement inputToWrite2;

    private List<Suggestion<String>> expectedSuggForB;
    private List<Suggestion<String>> expectedSuggForBr;
    private List<Suggestion<String>> expectedSuggForBrn;

    // ##################################################################################################################
    // Tests
    // ##################################################################################################################

    @Test
    public void testAreSuggestionsAvailable() {
        boolean result = autocompleteComponent.areSuggestionsAvailable();
        assertFalse(result, "Nothing was written into autocomplete input, therefore no suggestion should be available.");

        inputToWrite.sendKeys("X");
        result = autocompleteComponent.areSuggestionsAvailable();
        assertFalse(result, "No suggestion should available, as for written input no suggestions exist!");
        inputToWrite.clear();

        inputToWrite.sendKeys("B");
        waitForSuggestions(2);
        result = autocompleteComponent.areSuggestionsAvailable();
        assertTrue(result, "Suggestion should be available as there was input for which suggestions do exist");
    }

    @Test
    public void testClearByBackspace() {
        clearInput(ClearType.BACK_SPACE);
    }

    @Test
    public void testClearByDelete() {
        clearInput(ClearType.DELETE);
    }

    @Test
    public void testClearByEscapeSequence() {
        clearInput(ClearType.ESCAPE_SQ);
    }

    @Test
    public void testFinish() {
        String expected = "Br";
        inputToWrite.sendKeys(expected);
        waitForSuggestions(2);

        autocompleteComponent.finish();

        String actual = inputToWrite.getAttribute("value");
        assertEquals(actual, expected,
            "The value in the input should be different! It should be the one directly written to it, not the suggestion!");
    }

    @Test
    public void testGetAllSugestions() {
        initExpectedSuggestionsLists();

        checkGetAllSuggestionsFor("B", expectedSuggForB);

        checkGetAllSuggestionsFor("Br", expectedSuggForBr);

        checkGetAllSuggestionsFor("Brn", expectedSuggForBrn);
    }

    @Test
    public void testType() {
        String expected = "B";
        autocompleteComponent.type(expected);

        String actual = inputToWrite.getAttribute("value");
        assertEquals(actual, expected, "The input value is different than what was type there!");

        expected = "Br";
        autocompleteComponent.type("r");

        actual = inputToWrite.getAttribute("value");
        assertEquals(actual, expected, "The input value is different than what was type there!");
    }

    @Test
    public void testTypeWithParser() {
        initExpectedSuggestionsLists();
        String input = "B";
        StringSuggestionParserImpl parser = new StringSuggestionParserImpl();

        List<Suggestion<String>> suggestions = autocompleteComponent.type(input, parser);
        assertEquals(inputToWrite.getAttribute("value"), input, "The value was not written into input correclty!");
        assertTrue(suggestions.containsAll(expectedSuggForB), "Suggestions for input: " + input + " are wrong!");
        assertEquals(suggestions.size(), expectedSuggForB.size(), "Retrieved suggestions has some redundant suggestions.");

        input = "Br";
        suggestions = autocompleteComponent.type("r", parser);
        assertEquals(inputToWrite.getAttribute("value"), input, "The value was not written into input correclty!");
        assertTrue(suggestions.containsAll(expectedSuggForBr), "Suggestions for input: " + input + " are wrong!");
        assertEquals(suggestions.size(), expectedSuggForBr.size(), "Retrieved suggestions has some redundant suggestions.");

    }

    // ##################################################################################################################
    // Help Methods
    // ##################################################################################################################

    private void checkGetAllSuggestionsFor(String input, List<Suggestion<String>> expectedSugg) {
        inputToWrite.sendKeys(input);
        waitForSuggestions(2);

        List<Suggestion<String>> actualSuggestions = autocompleteComponent.getAllSuggestions(new StringSuggestionParserImpl());

        assertTrue(actualSuggestions.containsAll(expectedSugg), "Suggestions for input: " + input + " are wrong!");
        assertEquals(actualSuggestions.size(), expectedSugg.size(), "Retrieved suggestions has some redundant suggestions.");
        inputToWrite.clear();
    }

    private void initExpectedSuggestionsLists() {
        SuggestionImpl<String> brno = new SuggestionImpl<String>("Brno");
        SuggestionImpl<String> bratislava = new SuggestionImpl<String>("Bratislava");
        SuggestionImpl<String> berlin = new SuggestionImpl<String>("Berlin");

        expectedSuggForB = new ArrayList<Suggestion<String>>();
        expectedSuggForB.add(berlin);
        expectedSuggForB.add(bratislava);
        expectedSuggForB.add(brno);

        expectedSuggForBr = new ArrayList<Suggestion<String>>();
        expectedSuggForBr.add(bratislava);
        expectedSuggForBr.add(brno);

        expectedSuggForBrn = new ArrayList<Suggestion<String>>();
        expectedSuggForBrn.add(brno);
    }

    private void clearInput(ClearType clearType) {
        String testString = "test";
        inputToWrite.sendKeys(testString);

        String inputValue = inputToWrite.getAttribute("value");
        assertEquals(inputValue, testString, "Nothing was written to input!");

        autocompleteComponent.clear(clearType);
        inputValue = inputToWrite.getAttribute("value");
        assertTrue(inputValue.isEmpty(), "The input should be emtpy but was: " + inputValue);

        inputToWrite.clear();
    }

    private void waitForSuggestions(int timeout) {
        (new WebDriverWait(webDriver, timeout)).until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver d) {
                return suggestionList1.isDisplayed();
            }
        });
    }
}
