package cz.fi.muni.jhuska.bc.drone.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.File;
import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.context.GrapheneContext;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.fi.muni.jhuska.bc.api.AbstractComponentStub;

public class TestInitializingComponent extends Arquillian {

	@FindBy(xpath = "//div[@id='rootElement']")
	AbstractComponentStub abstractComponent;
	
	@FindBy(xpath = "//div[@id='rootElement']")
	WebElement element;

	private final String EXPECTED_NESTED_ELEMENT_TEXT = "Some Value";

	@Drone
	WebDriver driver;

	@ArquillianResource
	protected URL contextRoot;

	private static final String WEB_APP_SRC = "src/test/webapp";

	@Deployment(testable = false)
	public static WebArchive deploy() {
		return ShrinkWrap.create(WebArchive.class, "drone-test.war")
				.addAsWebResource(new File(WEB_APP_SRC + "/index.html"),
						ArchivePaths.create("index.html"));
	}
	
	@BeforeMethod
	public void initGrapheneContext() {
		GrapheneContext.set(driver);
	}

	@Test
	public void testComponentIsInitialized() {
		assertNotNull(abstractComponent,
				"AbstractComponent should be initialised at this point!");
	}

	@Test
	public void testComponentHasSetRootCorrectly() {
		driver.get(contextRoot + "index.html");

		assertEquals(abstractComponent.invokeMethodOnElementRefByXpath(),
				EXPECTED_NESTED_ELEMENT_TEXT, "The root was not set correctly!");
	}

}
