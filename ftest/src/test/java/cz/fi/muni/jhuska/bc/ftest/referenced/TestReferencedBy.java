package cz.fi.muni.jhuska.bc.ftest.referenced;

import static org.testng.Assert.assertEquals;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.fi.muni.jhuska.bc.api.AbstractComponent;
import cz.fi.muni.jhuska.bc.api.AbstractComponentStub;
import cz.fi.muni.jhuska.bc.api.Factory;
import cz.fi.muni.jhuska.bc.ftest.AbstractTest;

public class TestReferencedBy extends AbstractTest {

    private AbstractComponent abstractComponentMock;
    
    private final String TEXT_VALUE_REF_BY_CLASS_NAME = "Referenced by className";
    private final String TEXT_VALUE_REF_BY_CSS = "Referenced by css";
    private final String TEXT_VALUE_REF_BY_ID = "Referenced by id";
    private final String TEXT_VALUE_REF_BY_LINK_TEXT = "linkTextRef";
    private final String TEXT_VALUE_REF_BY_PARTIAL_LINK_TEXT = "partiaLinkTextRef";
    private final String TEXT_VALUE_REF_BY_TAG_NAME = "tagNameRef";
    private final String TEXT_VALUE_REF_BY_XPATH = "Referenced by xpath";
    private final String TEXT_VALUE_REF_BY_NAME = "Referenced by name";
    
    @Deployment(testable=false)
    public static WebArchive deploy() {
        return createDeployment(TestReferencedBy.class);
    }
    
    @BeforeClass
    public void initComponent() {
        abstractComponentMock = Factory.initializeComponent(AbstractComponentStub.class);
    }
    
    @BeforeMethod
    public void resetAbstractComponentMock() {
        abstractComponentMock.setRoot(webDriver.findElement(By.xpath("//*[contains(@id,'root')]")));
    }
    
    @Test
    public void testReferencedByClassName() {
        String actualTextValue = ((AbstractComponentStub)abstractComponentMock).invokeMethodOnElementRefByClass();
        assertEquals(actualTextValue, TEXT_VALUE_REF_BY_CLASS_NAME); 
    }
    
    @Test
    public void testReferencedById() {
        String actualTextValue = ((AbstractComponentStub)abstractComponentMock).invokeMethodOnElementRefById();
        assertEquals(actualTextValue, TEXT_VALUE_REF_BY_ID);
    }
    
    @Test
    public void testReferencedByCSS() {
        String actualTextValue = ((AbstractComponentStub)abstractComponentMock).invokeMethodOnElementRefByCSS();
        assertEquals(actualTextValue, TEXT_VALUE_REF_BY_CSS);
    }
    
    @Test
    public void testReferencedByName() {
        String actualTextValue = ((AbstractComponentStub)abstractComponentMock).invokeMethodOnElementRefByName();
        assertEquals(actualTextValue, TEXT_VALUE_REF_BY_NAME);
    }
    
    @Test
    public void testReferencedByTagName() {
        String actualTextValue = ((AbstractComponentStub)abstractComponentMock).invokeMethodOnElementRefByTagName();
        assertEquals(actualTextValue, TEXT_VALUE_REF_BY_TAG_NAME);
    }
    
    @Test
    public void testReferencedByLinkText() {
        String actualTextValue = ((AbstractComponentStub)abstractComponentMock).invokeMethodOnElementRefByLinkText();
        assertEquals(actualTextValue, TEXT_VALUE_REF_BY_LINK_TEXT);
    }
    
    @Test
    public void testReferencedByPartialLinkText() {
        String actualTextValue = ((AbstractComponentStub)abstractComponentMock).invokeMethodOnElementRefByPartialLinkText();
        assertEquals(actualTextValue, TEXT_VALUE_REF_BY_PARTIAL_LINK_TEXT);
    }
    
    @Test
    public void testReferencedByXPath() {
        String actualTextValue = ((AbstractComponentStub)abstractComponentMock).invokeMethodOnElementRefByXpath();
        assertEquals(actualTextValue, TEXT_VALUE_REF_BY_XPATH);
    }
}
