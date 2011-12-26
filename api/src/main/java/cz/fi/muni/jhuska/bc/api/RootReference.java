package cz.fi.muni.jhuska.bc.api;

public class RootReference {
	private WebElement root;
	
	public WebElement get() {
		return root;
	}
	
	public void set(WebElement root) {
		this.root = root;
	}
}
