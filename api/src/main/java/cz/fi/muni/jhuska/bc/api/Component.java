package cz.fi.muni.jhuska.bc.api;

import org.openqa.selenium.WebElement;

/**
 * Interface for any web component
 * 
 * @author jhuska
 *
 */
public interface Component extends NestedElements  {

	void setRoot(WebElement root);

	WebElement getRoot();
}
