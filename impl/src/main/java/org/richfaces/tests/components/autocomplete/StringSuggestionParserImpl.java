package org.richfaces.tests.components.autocomplete;

import org.jboss.arquillian.graphene.spi.components.autocomplete.Suggestion;
import org.jboss.arquillian.graphene.spi.components.autocomplete.SuggestionParser;
import org.openqa.selenium.WebElement;

public class StringSuggestionParserImpl implements SuggestionParser<String> {

    @Override
    public Suggestion<String> parse(WebElement rootOfSuggestion) {
        String data = rootOfSuggestion.getText();
        Suggestion<String> suggestion = new SuggestionImpl<String>(data);
        
        return suggestion;
    }

}
