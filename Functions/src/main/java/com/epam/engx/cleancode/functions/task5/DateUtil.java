package com.epam.engx.cleancode.functions.task5;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private Calendar calendar = Calendar.getInstance();

	public Date changeToMidnight(Date date, boolean up) {
		setParametersToCalendar(date);
		addDateToCalendar(up);
		return calendar.getTime();
	}

	private void setParametersToCalendar(Date date) {
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	private void addDateToCalendar(boolean up) {
		int num;
		if(up) num = 1;
		else num = -1;
		calendar.add(Calendar.DATE, num);
	}
}
