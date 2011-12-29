package cz.fi.muni.jhuska.bc.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import cz.fi.muni.jhuska.bc.api.Factory;
import cz.fi.muni.jhuska.bc.impl.CalendarImpl;
import cz.fi.muni.jhuska.bc.impl.WebElementImpl;

public class TestCalendar {

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

		WebElementImpl root = new WebElementImpl();
		root.setReference("foo-bar");

		calendar.setRoot(root);

		String actualDayLocator = calendar.getDayLocator().getLocator();
		String expectedDayLocator = "foo-bar rf-cal-c";
		assertEquals(actualDayLocator, expectedDayLocator,
				"The day locator is not correct!");

		WebElementImpl anotherRoot = new WebElementImpl();
		anotherRoot.setReference("bar-foo");

		calendar.setRoot(anotherRoot);

		actualDayLocator = calendar.getDayLocator().getLocator();
		expectedDayLocator = "bar-foo rf-cal-c";
		assertEquals(actualDayLocator, expectedDayLocator,
				"The day locator is not correct!");

		anotherRoot.setReference("changed-reference-on-root-element");
		
		expectedDayLocator = "changed-reference-on-root-element rf-cal-c";
		actualDayLocator = calendar.getDayLocator().getLocator();
		assertEquals(actualDayLocator, expectedDayLocator,
				"The day locator is not correct!");

	}
}
