package cz.fi.muni.jhuska.bc.api;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

public interface WebElement {

	void setReference(String reference);
	
	void setParent(RootReference parent);
	
	String getLocator();
	
	void click();

	void submit();

	void sendKeys(CharSequence... keysToSend);

	void clear();

	String getTagName();

	String getAttribute(String name);

	boolean isSelected();

	boolean isEnabled();

	String getText();

	List<WebElement> findElements(By by);

	WebElement findElement(By by);

	boolean isDisplayed();

	Point getLocation();

	Dimension getSize();

	String getCssValue(String propertyName);
}
