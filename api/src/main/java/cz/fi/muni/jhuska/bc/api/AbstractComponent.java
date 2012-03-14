package cz.fi.muni.jhuska.bc.api;

import org.openqa.selenium.WebElement;

public class AbstractComponent implements Component {

	private RootReference rootReference = new RootReference();

	protected RootReference getRootReference() {
		return rootReference;
	}

	public void setRoot(WebElement root) {
		rootReference.set(root);
	}

	public WebElement getRoot() {
		return rootReference.get();
	}
}
