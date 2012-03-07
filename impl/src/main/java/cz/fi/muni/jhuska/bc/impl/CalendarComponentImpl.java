package cz.fi.muni.jhuska.bc.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import cz.fi.muni.jhuska.bc.annotations.ReferencedBy;
import cz.fi.muni.jhuska.bc.annotations.Root;
import cz.fi.muni.jhuska.bc.api.AbstractComponent;
import cz.fi.muni.jhuska.bc.api.CalendarComponent;
import cz.fi.muni.jhuska.bc.api.ScrollingType;

public class CalendarComponentImpl extends AbstractComponent implements CalendarComponent {

    @Root
    private WebElement root;

    @ReferencedBy(clazz = "rf-cal-inp")
    private WebElement input;

    @ReferencedBy(css = "td[class=\"rf-cal-hdr-month\"] > div")
    private WebElement showYearAndMonthEditorButton;

    @ReferencedBy(css = "img:nth-of-type(1)")
    private WebElement showCalendarButton;

    @ReferencedBy(clazz = "rf-cal-day-lbl")
    private WebElement popupWithCalendar;

    @ReferencedBy(css = "div[class=\"rf-cal-time-btn\"]:nth-of-type(1)")
    private WebElement okButton;

    private final String YEAR_LOCATOR_CSS = "div[class=\"rf-cal-edtr-btn\"]";
    private final String DAY_LOCATOR_CLASS = "rf-cal-c";

    /**
     * The format of date displayed on the calendar input, default dd/M/yyhh:mma
     */
    private String dateFormat = "dd/M/yy hh:mm a";

    public WebElement getProxiedRoot() {
        return root;
    }

    @Override
    public void showCalendar() {

        if (!popupWithCalendar.isDisplayed()) {
            showCalendarButton.click();
        }
    }

    @Override
    public void hideCalendar() {

        try {
            if (popupWithCalendar.isDisplayed()) {
                showCalendarButton.click();
            }
        } catch (NoSuchElementException ex) {
            throw new RuntimeException(
                "You are invoking hide mothod on non existing element, did you provide right ReferencedBy annotation or is not it an inline calendar?");
        }
    }

    @Override
    public Date getDate() {
        String dateString = input.getAttribute("value");
        if (dateString.trim().length() == 0) {
            return null;
        }

        if (dateFormat == null) {
            throw new RuntimeException("You have to set date format first to get date!");
        }
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Parse date exception: did you provided the right dateFormat?");
        }

        return date;
    }

    @Override
    public DateTime getDateTime() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void gotoDate(Date date) {
        showCalendar();

        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        int wishedYear = cal.get(Calendar.YEAR);
        // month is indexed from 0!
        int wishedMonth = cal.get(Calendar.MONTH);
        int wishedDay = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(new Date(System.currentTimeMillis()));

        int todayYear = cal.get(Calendar.YEAR);
        int todayMonth = cal.get(Calendar.MONTH);
        int todayDay = cal.get(Calendar.DAY_OF_MONTH);

        showYearAndMonthEditorButton.click();

        if ((wishedYear != todayYear) || (wishedMonth != todayMonth)) {

            List<WebElement> years = root.findElements(By.cssSelector(YEAR_LOCATOR_CSS));
            String txt;

            for (WebElement i : years) {

                txt = i.getText().trim();
                int year;

                if (txt.matches("\\d+?")) {
                    year = new Integer(txt);

                    if (wishedYear == year) {
                        i.click();
                        // break;
                    }
                } else if (txt.matches("[a-zA-Z]+?")) {
                    if (txt.equals("Jan") && wishedMonth == 0) {
                        i.click();
                        // break;
                    } else if (txt.equals("Feb") && wishedMonth == 1) {
                        i.click();
                        // break;
                    } else if (txt.equals("Mar") && wishedMonth == 2) {
                        i.click();
                        // break;
                    } else if (txt.equals("Apr") && wishedMonth == 3) {
                        i.click();
                        // break;
                    } else if (txt.equals("May") && wishedMonth == 4) {
                        i.click();
                        // break;
                    } else if (txt.equals("Jun") && wishedMonth == 5) {
                        i.click();
                        // break;
                    } else if (txt.equals("Jul") && wishedMonth == 6) {
                        i.click();
                        // break;
                    } else if (txt.equals("Aug") && wishedMonth == 7) {
                        i.click();
                        // break;
                    } else if (txt.equals("Sep") && wishedMonth == 8) {
                        i.click();
                        // break;
                    } else if (txt.equals("Oct") && wishedMonth == 9) {
                        i.click();
                        // break;
                    } else if (txt.equals("Nov") && wishedMonth == 10) {
                        i.click();
                        // break;
                    } else if (txt.equals("Dec") && wishedDay == 11) {
                        i.click();
                        // break;
                    }
                }
            }

            okButton.click();

        }
        
        List<WebElement> days = root.findElements(By.className(DAY_LOCATOR_CLASS));
        String txt;
        for (WebElement i : days) {
            txt = i.getText().trim();
            int day = new Integer(txt);
            if (day == wishedDay) {
                i.click();
                break;
            }
        }
    }

    @Override
    public void gotoDate(DateTime dateTime) {
        // TODO Auto-generated method stub

    }

    @Override
    public void gotoDate(Date date, ScrollingType type) {
        // TODO Auto-generated method stub

    }

    @Override
    public void gotoDate(DateTime dateTime, ScrollingType type) {
        // TODO Auto-generated method stub

    }

    @Override
    public CalendarDay gotoNextDay() {
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

    @Override
    public CalendarDay getDayOfMonth() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CalendarDay getDayOfMonth(int day) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CalendarDay> getDaysOfMonth() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CalendarDay getDayOfWeek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CalendarDay getDayOfWeek(int day) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CalendarDay> getDaysOfWeek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CalendarDay getDayOfYear() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CalendarDay getDayOfYear(int day) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CalendarDay> getDaysOfYear() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CalendarWeek getWeekOfMonth() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CalendarWeek getWeekOfMonth(int week) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CalendarWeek> getWeeksOfMonth() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CalendarWeek getWeekOfYear() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CalendarWeek getWeekOfYear(int week) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CalendarWeek> getWeeksOfYear() {
        // TODO Auto-generated method stub
        return null;
    }

    public WebElement getCalendarInput() {
        return input;
    }

    public void setCalendarInput(WebElement calendarInput) {
        this.input = calendarInput;
    }

    public WebElement getPopupWithCalendar() {
        return popupWithCalendar;
    }

    public void setPopupWithCalendar(WebElement popupWithCalendar) {
        this.popupWithCalendar = popupWithCalendar;
    }

    /**
     * @return the showCalendarButton
     */
    public WebElement getShowCalendarButton() {
        return showCalendarButton;
    }

    public String getYearLocator() {
        return YEAR_LOCATOR_CSS;
    }

    /**
     * @param showCalendarButton the showCalendarButton to set
     */
    public void setShowCalendarButton(WebElement showCalendarButton) {
        this.showCalendarButton = showCalendarButton;
    }

    public WebElement getInput() {
        return input;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setInput(WebElement input) {
        this.input = input;
    }

    public void setDateFormat(String dateFormat) {
        if (dateFormat == null) {
            throw new IllegalArgumentException("You can not set null as dateFormat!");
        }
        this.dateFormat = dateFormat;
    }

    public WebElement getShowYearAndMonthEditorButton() {
        return showYearAndMonthEditorButton;
    }

    public void setShowYearAndMonthEditorButton(WebElement showYearAndMonthEditorButton) {
        this.showYearAndMonthEditorButton = showYearAndMonthEditorButton;
    }
}
