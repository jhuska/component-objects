package cz.fi.muni.jhuska.bc.api;

import org.openqa.selenium.WebElement;

public class RootReference {
	
	private WebElement root = null;
	
	public WebElement get() {
		return root;
	}
	
	public void set(WebElement root) {
		this.root = root;
	}
}
