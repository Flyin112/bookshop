package com.bookshop.utils;

import java.util.Date;
import java.text.SimpleDateFormat;

public class FormatUtil {

	public static String dateToString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
