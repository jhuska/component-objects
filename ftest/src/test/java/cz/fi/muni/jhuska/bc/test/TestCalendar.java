package cz.fi.muni.jhuska.bc.test;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import cz.fi.muni.jhuska.bc.api.Factory;
import cz.fi.muni.jhuska.bc.impl.CalendarImpl;
import cz.fi.muni.jhuska.bc.impl.WebElementImpl;



public class TestCalendar {

	@Test
	public void testCalendarInit() {
		
		CalendarImpl calendar = (CalendarImpl) Factory.initializeComponent(CalendarImpl.class);
		assertNotNull(calendar);
		calendar.setRoot(new WebElementImpl("rf-cal-popup"));
		
		assertNotNull(calendar.getDate());
	}
}
