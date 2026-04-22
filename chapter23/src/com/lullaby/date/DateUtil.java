package com.lullaby.date;

import java.text.ParseException;
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

    /**
     * 根据给定的日期格式，将日期对象转化为字符串格式的日期
     * @param pattern 日期格式
     * @param dateStr 日期对象
     * @return 日期
     * @throws ParseException
     */
    public static Date parse(String pattern, String dateStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(dateStr);
    }
}
