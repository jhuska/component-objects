package cz.fi.muni.jhuska.bc.impl;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

import cz.fi.muni.jhuska.bc.api.By;
import cz.fi.muni.jhuska.bc.api.RootReference;
import cz.fi.muni.jhuska.bc.api.WebElement;

public class WebElementImpl implements WebElement {
	
	private String reference;
	
	private RootReference parent;

	@Override
	public String getLocator() {
		
		return (parent != null ? parent.get().getLocator() + " " : "") + (reference != null ? reference : "");
	}
	
	public String getReference() {
		return reference;
	}
	
	@Override
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public RootReference getParent() {
		return parent;
	}

	@Override
	public void setParent(RootReference parent) {
		this.parent = parent;
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
