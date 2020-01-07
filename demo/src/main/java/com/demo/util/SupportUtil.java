package com.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SupportUtil {
	
	public static String getCurrentFormattedDate() {
		Date date1 = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String dateTime = ft.format(date1).toString();
		return dateTime;
	}
}
