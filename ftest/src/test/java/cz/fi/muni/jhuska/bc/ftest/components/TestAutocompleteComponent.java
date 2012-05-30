package cz.fi.muni.jhuska.bc.ftest.components;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import cz.fi.muni.jhuska.bc.ftest.AbstractTest;
import cz.fi.muni.jhuska.bc.impl.AutocompleteComponentImpl;

public class TestAutocompleteComponent extends AbstractTest {
	
	@Deployment(testable=false)
	public static WebArchive createDeployment() {
		return createDeployment(TestAutocompleteComponent.class);
	}
	
	@FindBy(xpath="//input[@]")
	private AutocompleteComponentImpl<String> cities;
	
	@Test
	public void testAreSuggestionsAvailable() {
		
	}

}
