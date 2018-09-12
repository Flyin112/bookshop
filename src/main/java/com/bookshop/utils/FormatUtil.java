package com.bookshop.utils;

import java.util.Date;
import java.text.SimpleDateFormat;

public class FormatUtil {

	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
}
