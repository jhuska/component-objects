package cz.fi.muni.jhuska.bc.impl;

import cz.fi.muni.jhuska.bc.api.WebElement;

/*
 * uses generics to indicate of which type the locator determining the element is
 */
public class WebElementImpl implements WebElement {

	private String locator;

	public String getLocator() {
		return locator;
	}
	
	public WebElementImpl(String locator) {
		this.locator = locator;
	}
	
}
