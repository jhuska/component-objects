package cz.fi.muni.jhuska.bc.api;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

public interface Calendar extends Component {

	Date getDate();
	
	DateTime getDateTime();
	
	// TODO support for JODA time

	void gotoDate(Date date);
	
	void gotoDate(Date date, CalendarScrollingType type);
	
	public enum CalendarScrollingType {
		BY_KEYS,
		BY_MOUSE
	}
	
	CalendarDay getDay();
	
	List<CalendarDay> getDays();

	public interface CalendarDay {
		boolean isEnabled();
	}
	
	// TODO CalendarWeek
}