package cz.fi.muni.jhuska.bc.api;


public class AbstractComponent implements Component {
	
	private RootReference rootReference = new RootReference();
	
	protected RootReference getRootReference() {
		return rootReference;
	}
	
	@Override
	public void setRoot(WebElement root) {
		rootReference.set(root);
	}
	
	@Override
	public WebElement getRoot() {
		return rootReference.get();
	}
}
