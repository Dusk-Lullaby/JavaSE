package com.lullaby.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String format1 = "yyyy-MM-dd HH:mm:ss";
    public static final String format2 = "yyyy/MM/dd HH:mm:ss";
    public static final String format3 = "yyyy/MM/dd";
    public static final String format4 = "yyyy-MM-dd";

    public static String format(String pattern, Date date) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
}
