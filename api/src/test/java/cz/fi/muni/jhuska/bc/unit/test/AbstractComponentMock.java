package cz.fi.muni.jhuska.bc.unit.test;

import org.openqa.selenium.WebElement;

import cz.fi.muni.jhuska.bc.annotations.ReferencedBy;
import cz.fi.muni.jhuska.bc.annotations.Root;
import cz.fi.muni.jhuska.bc.api.AbstractComponent;

public class AbstractComponentMock extends AbstractComponent {

    @Root
    private WebElement root;

    @ReferencedBy(clazz = "classNameRef")
    private WebElement locatorRefByClassName;

    @ReferencedBy(name = "nameRef")
    private WebElement locatorRefByName;

    @ReferencedBy(id = "idRef")
    private WebElement locatorRefById;

    @ReferencedBy(tagName = "tagNameRef")
    private WebElement locatorRefByTagName;

    @ReferencedBy(linkText = "linkTextRef")
    private WebElement locatorRefByLinkText;

    @ReferencedBy(partialLinkText = "partiaLinkTextRef")
    private WebElement locatorRefByPartialLinkText;

    @ReferencedBy(xPath = "xpathRef")
    private WebElement locatorRefByXPath;

    @ReferencedBy(css = "cssSelectorRef")
    private WebElement locatorRefByCssSelector;

    public String invokeMethodOnRoot() {
        return root.getText();
    }

    public String invokeMethodOnElementRefByClass() {
        return this.locatorRefByClassName.getText();
    }

    public WebElement getRootProxy() {
        return this.root;
    }

    public WebElement getLocatorRefByClassName() {
        return locatorRefByClassName;
    }

    public void setLocatorRefByClassName(WebElement locatorRefByClassName) {
        this.locatorRefByClassName = locatorRefByClassName;
    }

    public WebElement getLocatorRefByName() {
        return locatorRefByName;
    }

    public void setLocatorRefByName(WebElement locatorRefByName) {
        this.locatorRefByName = locatorRefByName;
    }

    public WebElement getLocatorRefById() {
        return locatorRefById;
    }

    public void setLocatorRefById(WebElement locatorRefById) {
        this.locatorRefById = locatorRefById;
    }

    public WebElement getLocatorRefByTagName() {
        return locatorRefByTagName;
    }

    public void setLocatorRefByTagName(WebElement locatorRefByTagName) {
        this.locatorRefByTagName = locatorRefByTagName;
    }

    public WebElement getLocatorRefByLinkText() {
        return locatorRefByLinkText;
    }

    public void setLocatorRefByLinkText(WebElement locatorRefByLinkText) {
        this.locatorRefByLinkText = locatorRefByLinkText;
    }

    public WebElement getLocatorRefByPartialLinkText() {
        return locatorRefByPartialLinkText;
    }

    public void setLocatorRefByPartialLinkText(WebElement locatorRefByPartialLinkText) {
        this.locatorRefByPartialLinkText = locatorRefByPartialLinkText;
    }

    public WebElement getLocatorRefByXPath() {
        return locatorRefByXPath;
    }

    public void setLocatorRefByXPath(WebElement locatorRefByXPath) {
        this.locatorRefByXPath = locatorRefByXPath;
    }

    public WebElement getLocatorRefByCssSelector() {
        return locatorRefByCssSelector;
    }

    public void setLocatorRefByCssSelector(WebElement locatorRefByCssSelector) {
        this.locatorRefByCssSelector = locatorRefByCssSelector;
    }

}
