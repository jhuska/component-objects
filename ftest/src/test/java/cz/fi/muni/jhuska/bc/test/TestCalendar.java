package cz.fi.muni.jhuska.bc.test;

import static org.testng.Assert.assertNotNull;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cz.fi.muni.jhuska.bc.api.Factory;
import cz.fi.muni.jhuska.bc.impl.CalendarImpl;

public class TestCalendar {
	
	@BeforeTest
	public void initializeMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCalendarInit() {

		CalendarImpl calendar = (CalendarImpl) Factory
				.initializeComponent(CalendarImpl.class);

		assertNotNull(calendar, "The calendar should be initialized!");
		assertNotNull(calendar.getYearLocator(),
				"The year locator should be initialized!");
		assertNotNull(calendar.getDayLocator(),
				"The day locator should be initialized!");
		assertNotNull(calendar.getMonthLocator(),
				"The month locator should be initialized!");
		assertNotNull(calendar.getWeekLocator(),
				"The week locator should be initialized!");
	}

	@Test
	public void testRootSetting() {

		CalendarImpl calendar = (CalendarImpl) Factory
				.initializeComponent(CalendarImpl.class);
		
		WebElement root = Mockito.mock(WebElement.class);
		
		String sampleText = "test";
		Mockito.when(root.getText()).thenReturn(sampleText);
		
		calendar.setRoot(root);
		
		Assert.assertEquals(calendar.getRoot(), root);
		
		Assert.assertSame(calendar.getProxiedRoot().getText(), sampleText);
		
		
		
		

//		String actualDayLocator = calendar.getDayLocator().getLocator();
//		String expectedDayLocator = "foo-bar rf-cal-c";
//		assertEquals(actualDayLocator, expectedDayLocator,
//				"The day locator is not correct!");
//
//		WebElementImpl anotherRoot = new WebElementImpl();
//		anotherRoot.setReference("bar-foo");
//
//		calendar.setRoot(anotherRoot);
//
//		actualDayLocator = calendar.getDayLocator().getLocator();
//		expectedDayLocator = "bar-foo rf-cal-c";
//		assertEquals(actualDayLocator, expectedDayLocator,
//				"The day locator is not correct!");
//
//		anotherRoot.setReference("changed-reference-on-root-element");
//		
//		expectedDayLocator = "changed-reference-on-root-element rf-cal-c";
//		actualDayLocator = calendar.getDayLocator().getLocator();
//		assertEquals(actualDayLocator, expectedDayLocator,
//				"The day locator is not correct!");

	}
}
