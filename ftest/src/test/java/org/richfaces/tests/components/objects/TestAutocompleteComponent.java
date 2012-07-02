package org.richfaces.tests.components.objects;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.support.FindBy;
import org.richfaces.tests.components.AbstractTest;
import org.richfaces.tests.components.AutocompleteComponentImpl;
import org.testng.annotations.Test;

public class TestAutocompleteComponent extends AbstractTest {
	
	@Deployment(testable=false)
	public static WebArchive createDeployment() {
		return createDeployment(TestAutocompleteComponent.class);
	}
	
	@FindBy(xpath="//input[@]")
	private AutocompleteComponentImpl<String> cities;
	
//	@Test
	public void testAreSuggestionsAvailable() {
		
	}

}
