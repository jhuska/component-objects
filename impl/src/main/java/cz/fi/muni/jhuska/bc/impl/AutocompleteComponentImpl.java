package cz.fi.muni.jhuska.bc.impl;

import java.util.List;

import org.openqa.selenium.WebElement;

import cz.fi.muni.jhuska.bc.components.autocomplete.AutocompleteComponent;
import cz.fi.muni.jhuska.bc.components.autocomplete.Suggestion;
import cz.fi.muni.jhuska.bc.components.common.AbstractComponent;
import cz.fi.muni.jhuska.bc.components.scrolling.ScrollingType;

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
	public void clear(
			cz.fi.muni.jhuska.bc.components.autocomplete.AutocompleteComponent.ClearType clearType) {
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
