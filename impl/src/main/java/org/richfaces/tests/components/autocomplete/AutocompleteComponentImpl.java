package org.richfaces.tests.components.autocomplete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jboss.arquillian.graphene.spi.annotations.Root;
import org.jboss.arquillian.graphene.spi.components.autocomplete.AutocompleteComponent;
import org.jboss.arquillian.graphene.spi.components.autocomplete.ClearType;
import org.jboss.arquillian.graphene.spi.components.autocomplete.Suggestion;
import org.jboss.arquillian.graphene.spi.components.autocomplete.SuggestionParser;
import org.jboss.arquillian.graphene.spi.components.common.AbstractComponent;
import org.jboss.arquillian.graphene.spi.components.scrolling.ScrollingType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutocompleteComponentImpl<T> extends AbstractComponent implements AutocompleteComponent<T> {

    public static final String CLASS_NAME_SUGGESTION_LIST = "rf-au-lst-cord";
    public static final String CLASS_NAME_SUGGESTION = "rf-au-itm";
    public static final String CSS_INPUT = "input[type='text']";

    @Root
    WebElement root;

    @FindBy(css = CSS_INPUT)
    WebElement inputToWrite;

    private String separator = " ";

    @Override
    public boolean areSuggestionsAvailable() {

        // the problem here is that suggestion list object in DOM is moved out of the autocomplete component's form when it is
        // displayed, therefore at first it is neccessary to find correct suggestion list and then check if it is displayed
        List<WebElement> suggestionLists = root.findElements(By.xpath("//*[contains(@class,'" + CLASS_NAME_SUGGESTION_LIST
            + "')]"));

        WebElement suggList = getRightSuggestionList();

        return suggList.isDisplayed();
    }

    /**
     * Returns suggestion list of this autocomplete, null if there is not any.
     * 
     * @return
     */
    private WebElement getRightSuggestionList() {

        List<WebElement> suggestionLists = root.findElements(By.xpath("//*[contains(@class,'" + CLASS_NAME_SUGGESTION_LIST
            + "')]"));

        for (WebElement suggList : suggestionLists) {
            String idOfSuggLst = suggList.getAttribute("id");
            String idOfInput = inputToWrite.getAttribute("id");

            int index = idOfSuggLst.indexOf("List");
            boolean result = idOfInput.contains(idOfSuggLst.substring(0, index));

            if (result) {
                return suggList;
            }
        }

        return null;
    }

    @Override
    public void clear(ClearType clearType) {
        // TODO clear the input accordign to the cleartype
        // it will need to send key
        // check http://code.google.com/p/selenium/wiki/AdvancedUserInteractions
        // probably I will need instance for webdriver in AbstractComponent

        if (clearType == ClearType.BACK_SPACE) {
            Actions builder = new Actions(webDriver);
            
            builder.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);
            builder.build().perform();
        }

        if (clearType == ClearType.ESCAPE_SQ) {
            StringBuilder sb = new StringBuilder();

            int valueLength = inputToWrite.getAttribute("value").length();
            for (int i = 0; i < valueLength; i++) {
                sb.append("\b");
            }

            inputToWrite.sendKeys(sb.toString());
            root.click();
        }

        if (clearType == ClearType.DELETE) {
            throw new UnsupportedOperationException("not implemented yet");
        }
    }

    @Override
    public void finish() {
        inputToWrite.sendKeys(" ");
        inputToWrite.sendKeys("\b\b");
        root.click();
    }

    @Override
    public List<Suggestion<T>> getAllSuggestions(SuggestionParser<T> parser) {
        List<Suggestion<T>> allSugg = new ArrayList<Suggestion<T>>();

        if (areSuggestionsAvailable()) {
            WebElement rightSuggList = getRightSuggestionList();
            List<WebElement> suggestions = rightSuggList.findElements(By.className(CLASS_NAME_SUGGESTION));

            for (WebElement suggestion : suggestions) {
                allSugg.add(parser.parse(suggestion));
            }
        }

        return allSugg;
    }

    @Override
    public List<Suggestion<T>> getSelectedSuggestions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> getInputValues() {
        List<String> inputValues = new ArrayList<String>();

        String currentInputValue = inputToWrite.getAttribute("value");
        inputValues = Arrays.asList(currentInputValue.split(separator));
        
        return inputValues;
    }

    @Override
    public void setSeparator(String regex) {
        this.separator = regex;
    }

    @Override
    public List<Suggestion<T>> getFirstNSuggestions(int n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Suggestion<T> getFirstSuggestion() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Suggestion<T> getNthSuggestion(int order) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void type(String value) {
        inputToWrite.sendKeys(value);
        try {
            waitForSuggestions(GUI_WAIT);
        } catch (TimeoutException ex) {
            // no suggestions available

        }
    }

    @Override
    public List<Suggestion<T>> type(String value, SuggestionParser<T> parser) {
        List<Suggestion<T>> suggestions = new ArrayList<Suggestion<T>>();

        inputToWrite.sendKeys(value);
        try {
            waitForSuggestions(GUI_WAIT);
        } catch (TimeoutException ex) {
            // no suggestions available
            return suggestions;
        }

        suggestions = getAllSuggestions(parser);
        return suggestions;
    }

    private void waitForSuggestions(int timeout) {
        (new WebDriverWait(webDriver, timeout)).until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver d) {
                return areSuggestionsAvailable();
            }
        });
    }

    @Override
    public boolean autocompleteWithSuggestion(Suggestion<T> sugg) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean autocompleteWithSuggestion(Suggestion<T> sugg, ScrollingType scrollingType) {
        // TODO Auto-generated method stub
        return false;
    }
}
