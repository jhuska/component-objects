package cz.fi.muni.jhuska.bc.ftest.referenced;

import static org.testng.Assert.assertEquals;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cz.fi.muni.jhuska.bc.api.AbstractComponent;
import cz.fi.muni.jhuska.bc.api.Factory;
import cz.fi.muni.jhuska.bc.ftest.AbstractTest;

public class TestSettingRootAndReferenced extends AbstractTest {

    private AbstractComponent abstractComponent;

    private final String TEXT_FIRST_ROOT_ANCHOR = "Anchor nested in first root";
    private final String TEXT_SECOND_ROOT_ANCHOR = "Anchor nested in second root";

    @Deployment(testable=false)
    public static WebArchive createDeployment() {
        return createDeployment(TestSettingRootAndReferenced.class);
    }

    @BeforeClass
    public void initComponents() {
        abstractComponent = Factory.initializeComponent(AbstractComponentMock.class);
    }

    @Test
    public void testSettingRoot() {
        abstractComponent.setRoot(webDriver.findElement(By.xpath("//*[contains(@id,'root1')]")));

        assertEquals(((AbstractComponentMock) abstractComponent).invokeMethodOnElementRefByName(), TEXT_FIRST_ROOT_ANCHOR,
            "The text from first nested element is wrong!");

        abstractComponent.setRoot(webDriver.findElement(By.xpath("//*[contains(@id,'root2')]")));

        assertEquals(((AbstractComponentMock) abstractComponent).invokeMethodOnElementRefByName(), TEXT_SECOND_ROOT_ANCHOR,
            "The text from second nested element is wrong!");
    }
}
