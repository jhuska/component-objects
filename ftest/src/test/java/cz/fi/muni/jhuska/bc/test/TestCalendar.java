package cz.fi.muni.jhuska.bc.test;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.fi.muni.jhuska.bc.api.Calendar;
import cz.fi.muni.jhuska.bc.api.Factory;
import cz.fi.muni.jhuska.bc.impl.CalendarImpl;

public class TestCalendar extends Arquillian {

    private Calendar calendar;
    private WebElement calendarRoot;
    private WebDriver webDriver;

    @Deployment(testable=false)
    public static WebArchive createDeployment() {
//        WebArchive war = ShrinkWrap
//            .create(WebArchive.class, "ftest-app.war")
//            .addAsWebInfResource(new File("src/test/webapp/WEB-INF/web.xml"))
//            .addAsWebResource(new File("src/test/webapp/components/calendar.xhtml"))
//            .addAsWebResource(new File("src/test/webapp/resources/script/jquery-min.js"),
//                ArchivePaths.create("resources/script/jquery-min.js"));
            
        WebArchive war = ShrinkWrap.createFromZipFile( WebArchive.class, new File("target/showcase.war") );
        return war;
    }

    @BeforeClass
    public void initCalendar() {
        calendar = Factory.initializeComponent(CalendarImpl.class);

        webDriver = new FirefoxDriver();
    }

    @BeforeMethod
    public void loadTestPage() {
        webDriver.get("http://localhost:8080/showcase/richfaces/component-sample.jsf?demo=calendar&skin=blueSky");
        
        calendarRoot = webDriver.findElement(By.xpath("//td[@class='ecol1']"));
        calendar.setRoot(calendarRoot);
    }

    @Test
    public void testShowCalendar() {
        calendar.showCalendar();

        WebElement popup = webDriver.findElement(By.xpath("/html/body/div/div[2]/div[2]/fieldset/form/table/tbody/tr/td/div/span/table/tbody/tr/td/table/tbody/tr/td[3]/div"));
        assertTrue(popup.isDisplayed(), "The popup of the calendar should be displayed!");
    }
}
