package cz.fi.muni.jhuska.bc.impl;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.openqa.selenium.WebElement;

import cz.fi.muni.jhuska.bc.annotations.ReferencedBy;
import cz.fi.muni.jhuska.bc.annotations.Root;
import cz.fi.muni.jhuska.bc.api.AbstractComponent;
import cz.fi.muni.jhuska.bc.api.Calendar;

public class CalendarImpl extends AbstractComponent implements Calendar {

	@Root
	private WebElement root;

	@ReferencedBy(clazz = "rf-cal-c")
	private WebElement dayLocator;

	@ReferencedBy(clazz = "rf-cal-tl-btn[onclick*='showDateEditor']")
	private WebElement monthLocator;

	@ReferencedBy(clazz = "rf-cal-tl-btn[onclick*='showDateEditor']")
	private WebElement yearLocator;

	@ReferencedBy(clazz = "rf-cal-week")
	private WebElement weekLocator;
	
	@ReferencedBy(xPath="//*[@id=\"j_idt103:calendarPopupButton\"]")
	private WebElement showCalendarButton;
	
	public WebElement getProxiedRoot() {
		return root;
	}

	@Override
	public void showCalendar() {
	    showCalendarButton.click();
	}

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime getDateTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void gotoDate(Date date) {
		// TODO Auto-generated method stub

	}

	@Override
	public void gotoDate(Date date, CalendarScrollingType type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void gotoDateTime(DateTime dateTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void gotoDateTime(DateTime dateTime, CalendarScrollingType type) {
		// TODO Auto-generated method stub

	}

	@Override
	public CalendarDay gotoNextDay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarWeek gotoNextWeek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarMonth gotoNextMonth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarYear gotoNextYear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarDay gotoPreviousDay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarWeek gotoPreviousWeek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarMonth gotoPreviousMonth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarYear gotoPreviousYear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarDay getDay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarDay getDay(int day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CalendarDay> getDays() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarWeek getWeek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarWeek getWeek(int week) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CalendarWeek> getWeeks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarMonth getMonth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarMonth getMonth(int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CalendarMonth> getMonths() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarYear getYear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalendarYear getYear(int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CalendarYear> getYears(int from, int to) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement getDayLocator() {
		return dayLocator;
	}

	public void setDayLocator(WebElement dayLocator) {
		this.dayLocator = dayLocator;
	}

	public WebElement getMonthLocator() {
		return monthLocator;
	}

	public void setMonthLocator(WebElement monthLocator) {
		this.monthLocator = monthLocator;
	}

	public WebElement getYearLocator() {
		return yearLocator;
	}

	public void setYearLocator(WebElement yearLocator) {
		this.yearLocator = yearLocator;
	}

	public WebElement getWeekLocator() {
		return weekLocator;
	}

	public void setWeekLocator(WebElement weekLocator) {
		this.weekLocator = weekLocator;
	}

    /**
     * @return the showCalendarButton
     */
    public WebElement getShowCalendarButton() {
        return showCalendarButton;
    }

    /**
     * @param showCalendarButton the showCalendarButton to set
     */
    public void setShowCalendarButton(WebElement showCalendarButton) {
        this.showCalendarButton = showCalendarButton;
    }

}
