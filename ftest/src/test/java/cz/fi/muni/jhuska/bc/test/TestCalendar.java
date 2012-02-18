package cz.fi.muni.jhuska.bc.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.fi.muni.jhuska.bc.api.Calendar;
import cz.fi.muni.jhuska.bc.api.Factory;
import cz.fi.muni.jhuska.bc.impl.CalendarImpl;

public class TestCalendar extends AbstractTest {

//    @FindBy(xpath = "//td[@class='ecol1']")
    private Calendar calendar;

    // @Inject
    // private Page page;

    private WebElement calendarRoot;

    @Deployment(testable=false)
    public static WebArchive deploy() {
        return createDeployment(TestCalendar.class);
    }

    @BeforeClass
    public void initCalendar() {
        calendar = Factory.initializeComponent(CalendarImpl.class);

        webDriver = new FirefoxDriver();
    }
    
    @BeforeMethod
    public void resetCalendar() {
        calendarRoot = webDriver.findElement(By.xpath("//*[contains(@id, 'calendar')]"));
        calendar.setRoot(calendarRoot);
    }

    @Test
    public void testShowCalendar() {
        
        WebElement popup = webDriver
            .findElement(By
                .xpath("//*[contains(@id,'calendarDayCell2')]"));
        assertFalse(popup.isDisplayed(), "The popup should not be displayed yet, since it was not invoked!");
        
        calendar.showCalendar();

        assertTrue(popup.isDisplayed(), "The popup of the calendar should be displayed!");
    }
}
