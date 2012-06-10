package org.richfaces.tests.components;

import java.util.List;

import org.jboss.arquillian.graphene.spi.components.autocomplete.AutocompleteComponent;
import org.jboss.arquillian.graphene.spi.components.autocomplete.ClearType;
import org.jboss.arquillian.graphene.spi.components.autocomplete.Suggestion;
import org.jboss.arquillian.graphene.spi.components.common.AbstractComponent;
import org.jboss.arquillian.graphene.spi.components.scrolling.ScrollingType;
import org.openqa.selenium.WebElement;

public class AutocompleteComponentImpl<T> extends AbstractComponent implements
		AutocompleteComponent<T> {

	@Override
	public void setRoot(WebElement root) {
		// TODO Auto-generated method stub

	}

	@Override
	public WebElement getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areSuggestionsAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear(ClearType clearType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Suggestion<T>> getAllSuggestions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suggestion<T> getSelectedSuggestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Suggestion<T>> getSelectedSuggestions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Suggestion<T>> getSelectedSuggestions(String regex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInputValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getInputValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getInputValues(String regex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSeparator(String regex) {
		// TODO Auto-generated method stub

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
	public List<Suggestion<T>> typeString(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean autocompleteWithSuggestion(Suggestion<T> sugg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean autocompleteWithSuggestion(Suggestion<T> sugg,
			ScrollingType scrollingType) {
		// TODO Auto-generated method stub
		return false;
	}

}
