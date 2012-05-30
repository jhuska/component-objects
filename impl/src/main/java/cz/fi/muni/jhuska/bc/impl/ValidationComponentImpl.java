package cz.fi.muni.jhuska.bc.impl;

import java.util.List;

import org.openqa.selenium.WebElement;

import cz.fi.muni.jhuska.bc.components.validation.ValidationComponent;

public class ValidationComponentImpl implements ValidationComponent {

	@Override
	public void setRoot(WebElement root) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WebElement getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getAllMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ErrorMessage> getAllErrorMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ErrorMessage> getAllInfoMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMessageRendered(Message msg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMessageRendered(StaticMessagePart msg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isThereAnyErrorMessage() {
		// TODO Auto-generated method stub
		return false;
	}

}
