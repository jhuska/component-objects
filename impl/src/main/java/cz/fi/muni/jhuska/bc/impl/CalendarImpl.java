package cz.fi.muni.jhuska.bc.impl;

import java.util.Date;
import java.util.List;

import cz.fi.muni.jhuska.bc.annotations.ReferencedBy;
import cz.fi.muni.jhuska.bc.annotations.Root;
import cz.fi.muni.jhuska.bc.api.AbstractComponent;
import cz.fi.muni.jhuska.bc.api.Calendar;
import cz.fi.muni.jhuska.bc.api.WebElement;

public class CalendarImpl extends AbstractComponent implements Calendar {

	@Root
	private WebElement root;
	
	@ReferencedBy(clazz="rf-cal-c")
	private WebElement dayLocator;
	
	@ReferencedBy(clazz="rf-cal-tl-btn[onclick*='showDateEditor']")
	private WebElement monthLocator;
	
	@ReferencedBy(clazz="rf-cal-tl-btn[onclick*='showDateEditor']")
	private WebElement yearLocator;
	
	@ReferencedBy(clazz="rf-cal-week")
	private WebElement weekLocator;
	
	@Override
	public void setRoot(WebElement root) {
		 this.root = root;
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

	@Override
	public WebElement getRoot() {
		return root;	
	}

	@Override
	public Date getDate() {
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
	public CalendarDay getDay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CalendarDay> getDays() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
