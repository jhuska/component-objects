package cz.fi.muni.jhuska.bc.api;

import java.util.Date;

import org.joda.time.DateTime;

/**
 * Calendar component represents any type of calendar.
 * 
 * @author jhuska
 */
public interface CalendarComponent extends Component {

    /**
     * Returns the set date, that is the date which is in input after date setting.
     *
     * @return the set date, or null in case no date is set
     * @throws RuntimeException when you provided wrong date format, see the field dateFormat
     * @see dateFormat
     */
    Date getDate();

    /**
     * Returns the set date, that is the date which is in input after date setting.
     *
     * @return the set date
     */
    DateTime getDateTime();

    /**
     * Sets the <code>date</code>, that is it selects that date and also sets to the input.
     *
     * @param date the date to set
     */
    void gotoDate(Date date);

    /**
     * Sets the <code>dateTime</code>, that is it selects that date and also sets to the input.
     *
     * @param dateTime the date to set
     */
    void gotoDate(DateTime dateTime);

    /**
     * Sets the <code>date</code> by the chosen way (for example by mouse), that is it selects that date and
     *
     * @param date the date to set
     * @param type the type of way to set the date, for example by mouse
     */
    void gotoDate(Date date, ScrollingType type);

    /**
     * Set the date on the calendar
     *
     * @param dateTime the date to set
     * @param type the type of way to set the date, for example by mouse
     */
    void gotoDate(DateTime dateTime, ScrollingType type);
}