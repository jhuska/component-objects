package cz.fi.muni.jhuska.bc.drone.test.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cz.fi.muni.jhuska.bc.api.AbstractComponentStub;
import cz.fi.muni.jhuska.bc.api.AbstractPage;

public class TestPage implements AbstractPage {

	@FindBy(xpath = "//div[@id='rootElement']")
	private AbstractComponentStub abstractComponent;

	@FindBy(xpath = "//div[@id='rootElement']")
	private WebElement element;

	@FindBy(xpath = "//input")
	private WebElement input;

	public AbstractComponentStub getAbstractComponent() {
		return abstractComponent;
	}

	public void setAbstractComponent(AbstractComponentStub abstractComponent) {
		this.abstractComponent = abstractComponent;
	}

	public WebElement getElement() {
		return element;
	}

	public void setElement(WebElement element) {
		this.element = element;
	}

	public WebElement getInput() {
		return input;
	}

	public void setInput(WebElement input) {
		this.input = input;
	}
}
