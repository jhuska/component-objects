package cz.fi.muni.jhuska.bc.api;

import org.openqa.selenium.WebElement;

public interface Component {

	void setRoot(WebElement root);

	WebElement getRoot();
}
