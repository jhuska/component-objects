package cz.fi.muni.jhuska.bc.api;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

public interface Calendar extends Component {

	void showCalendar();
	
	Date getDate();

	DateTime getDateTime();

	void gotoDate(Date date);

	void gotoDate(Date date, CalendarScrollingType type);

	void gotoDateTime(DateTime dateTime);

	void gotoDateTime(DateTime dateTime, CalendarScrollingType type);

	CalendarDay gotoNextDay();

	CalendarWeek gotoNextWeek();
	
	CalendarMonth gotoNextMonth();

	CalendarYear gotoNextYear();

	CalendarDay gotoPreviousDay();

	CalendarWeek gotoPreviousWeek();
	
	CalendarMonth gotoPreviousMonth();

	CalendarYear gotoPreviousYear();

	public enum CalendarScrollingType {
		BY_KEYS, BY_MOUSE
	}

	CalendarDay getDay();

	CalendarDay getDay(int day);

	List<CalendarDay> getDays();

	CalendarWeek getWeek();

	CalendarWeek getWeek(int week);

	List<CalendarWeek> getWeeks();

	CalendarMonth getMonth();

	CalendarMonth getMonth(int month);

	List<CalendarMonth> getMonths();

	CalendarYear getYear();

	CalendarYear getYear(int year);

	List<CalendarYear> getYears(int from, int to);

	public interface TimeUnit {
		int getValue();
	}

	public interface CalendarDay extends TimeUnit {
		boolean isEnabled();
	}

	public interface CalendarWeek extends TimeUnit {
		List<CalendarDay> getDays();

		CalendarDay getDay();

		CalendarDay getDay(int day);
	}

	public interface CalendarMonth extends TimeUnit {
		List<CalendarDay> getDays();

		List<CalendarWeek> getWeeks();

		CalendarDay getDay();

		CalendarDay getDay(int day);

		CalendarWeek getWeek();

		CalendarWeek getWeek(int week);
	}

	public interface CalendarYear extends TimeUnit {
		List<CalendarDay> getDays();

		List<CalendarWeek> getWeeks();

		List<CalendarMonth> getMonths();

		CalendarDay getDay();

		CalendarDay getDay(int day);

		CalendarWeek getWeek();

		CalendarWeek getWeek(int week);

		CalendarMonth getMonth();

		CalendarMonth getMonth(int month);
	}
}