package cz.fi.muni.jhuska.bc.drone.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTranslate {

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement translateButton;

	@FindBy(xpath="//textarea[@id='source']")
	private WebElement inputArea;
	
	@FindBy(xpath="//span[@id='result_box']")
	private WebElement resultArea;
	
	public String translate(String word, WebDriver webDriver) {
		inputArea.sendKeys(word);
		translateButton.click();
		
		(new WebDriverWait(webDriver, 4)).until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver d) {

                return (resultArea.getText().trim().length() > 0);
            }
        });
		
		return resultArea.getText().trim();
	}

	
	public void selectLanguageToTranslateTo(Language language) {

	}

	public void selectLanguageToTranslateFrom(Language language) {

	}
}
