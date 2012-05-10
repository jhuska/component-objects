package cz.fi.muni.jhuska.bc.drone.test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.fi.muni.jhuska.bc.annotations.Page;
import cz.fi.muni.jhuska.bc.drone.test.page.GoogleTranslate;
import cz.fi.muni.jhuska.bc.drone.test.page.Language;

public class TestGoogleTranslate extends Arquillian {
	
	@Drone
    WebDriver webDriver;
	
	@Page
	private GoogleTranslate googleTranslate;
	
	private static final String WEB_APP_SRC = "src/test/webapp";
	
	@Deployment(testable = false)
	public static WebArchive deploy() {
		return ShrinkWrap.create(WebArchive.class, "drone-test.war")
				.addAsWebResource(new File(WEB_APP_SRC + "/index.html"),
						ArchivePaths.create("index.html"));
	}
	
	@BeforeMethod
    public void loadPage() {
        webDriver.get("http://translate.google.com");
    }
	
	@Test
	public void testTranslateWord() {
		googleTranslate.selectLanguageToTranslateFrom(new Language("sk"));
		googleTranslate.selectLanguageToTranslateTo(new Language("en"));

		String wordToTranslate = "ryba";
		String expectedTranslation = "fish";
		
		String actualTranslation = googleTranslate.translate(wordToTranslate, webDriver);
		
		assertEquals(actualTranslation, expectedTranslation, "The word was translated incorrectly!");
	}
}
