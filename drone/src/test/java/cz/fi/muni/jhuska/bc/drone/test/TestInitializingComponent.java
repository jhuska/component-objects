package cz.fi.muni.jhuska.bc.drone.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.File;
import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
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

import cz.fi.muni.jhuska.bc.annotations.Page;
import cz.fi.muni.jhuska.bc.api.AbstractComponentStub;
import cz.fi.muni.jhuska.bc.api.AbstractPage;
import cz.fi.muni.jhuska.bc.drone.test.page.TestPage;

public class TestInitializingComponent extends Arquillian {

    @FindBy(xpath = "//div[@id='rootElement']")
    private AbstractComponentStub abstractComponent;

    @FindBy(xpath = "//input")
    private WebElement input;

    @Page
    private TestPage testPage;

    private final String EXPECTED_NESTED_ELEMENT_TEXT = "Some Value";

    @Drone
    WebDriver selenium;

    @ArquillianResource
    protected URL contextRoot;

    private static final String WEB_APP_SRC = "src/test/webapp";

    @Deployment(testable = false)
    public static WebArchive deploy() {
        return ShrinkWrap.create(WebArchive.class, "drone-test.war").addAsWebResource(new File(WEB_APP_SRC + "/index.html"),
            ArchivePaths.create("index.html"));
    }

    @BeforeMethod
    public void loadPage() {
        selenium.get(contextRoot + "index.html");
    }

    @Test
    public void testComponentIsInitialized() {
        assertNotNull(abstractComponent, "AbstractComponent should be initialised at this point!");
    }

    @Test
    public void testComponentHasSetRootCorrectly() {
        assertEquals(abstractComponent.invokeMethodOnElementRefByXpath(), EXPECTED_NESTED_ELEMENT_TEXT,
            "The root was not set correctly!");
    }

    @Test
    public void testPageObjectInitialisedCorrectly() {
        assertEquals(testPage.getAbstractComponent().invokeMethodOnElementRefByXpath(), EXPECTED_NESTED_ELEMENT_TEXT,
            "The page component was not set correctly!");
    }

    @Test
    public void testOtherWebElementsInitialisedCorrectly() {
        String EXPECTED_VALUE = "Gooseka";
        input.sendKeys(EXPECTED_VALUE);
        
        assertEquals(input.getAttribute("value"), EXPECTED_VALUE,
            "The value of the input is wrong, the element which represents it was not initialised correctly!");
    }
}
