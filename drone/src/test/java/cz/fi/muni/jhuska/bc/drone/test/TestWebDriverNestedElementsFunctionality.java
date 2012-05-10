package cz.fi.muni.jhuska.bc.drone.test;

import java.io.File;
import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.fi.muni.jhuska.bc.components.common.AbstractComponentStub;

public class TestWebDriverNestedElementsFunctionality extends Arquillian {
	
	@FindBy(xpath = "//div[@id='divWithNestedElements']")
    private WebElement divWithNestedElements;
	
	@Drone
    WebDriver webDriver;
	
	private static final String WEB_APP_SRC = "src/test/webapp";
	
	@ArquillianResource
    protected URL contextRoot;
	
	@Deployment(testable = false)
	public static WebArchive deploy() {
		return ShrinkWrap.create(WebArchive.class, "drone-test.war")
				.addAsWebResource(new File(WEB_APP_SRC + "/index.html"),
						ArchivePaths.create("index.html"));
	}
	
	@BeforeMethod
    public void loadPage() {
		webDriver.get(contextRoot + "index.html");
    }
	
	@Test
	public void testWebDriverNestedElementsFunctionality() {
		WebElement divWithClassFoo = divWithNestedElements.findElement(By.className("foo"));
		//String - This is going to be selected. - will be printed on the console.
		System.out.println(divWithClassFoo.getText());
	}

}
