package cz.fi.muni.jhuska.bc.components.calendar;

import java.util.Date;

import org.joda.time.DateTime;

import cz.fi.muni.jhuska.bc.components.common.Component;
import cz.fi.muni.jhuska.bc.components.scrolling.ScrollingType;

/**
 * Calendar component represents any type of calendar.
 * 
 * @author jhuska
 */
public interface CalendarComponent extends Component {

    /**
     * Returns the set date, that is the date which is in input after date setting.
     *
     * @return the set date
     */
    DateTime getDateTime();

    /**
     * Sets the <code>dateTime</code>, that is it selects that date and also sets to the input.
     *
     * @param dateTime the date to set
     */
    void gotoDateTime(DateTime dateTime);
}