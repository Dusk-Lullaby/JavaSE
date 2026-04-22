package com.lullaby.Calendar;

import com.lullaby.date.DateUtil;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

    public static void main(String[] args) {
        // 获取一个日历对象，默认是系统当前时间
        Calendar c = Calendar.getInstance();
        Date now = c.getTime(); // 获取日历中的当前日期
        System.out.println(now);
        long time = now.getTime() - 3 * 24 * 60 * 60 * 1000;
        c.setTime(new Date(time));  // 设置日历的日期
        System.out.println(c.getTime());

        int year = c.get(Calendar.YEAR);    // 获取日历中的年份
        System.out.println(year);
        int month = c.get(Calendar.MONTH) + 1;  // 获取日历中的月份，因为月份是从0开始，因此要+ 1
        System.out.println(month);
        int day = c.get(Calendar.DAY_OF_MONTH); // 获取月中的第几天
        System.out.println(day);
        int hour = c.get(Calendar.HOUR);
        int hour_24 = c.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);
        System.out.println(hour_24);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        System.out.println(minute);
        System.out.println(second);

        c.set(Calendar.YEAR, 1999); // 设置年份为1999
        c.set(Calendar.MONTH, 9 -1);    // 设置月份为9月
        c.set(Calendar.DAY_OF_MONTH, 10);   // 设置天数为该月第10天
        c.set(Calendar.HOUR_OF_DAY,18);
        c.set(Calendar.MINUTE, 30);
        c.set(Calendar.SECOND, 0);
        System.out.println(DateUtil.format(DateUtil.format1, c.getTime()));
        c.roll(Calendar.YEAR, 1);   // 年份+1
        String s1 = DateUtil.format(DateUtil.format1, c.getTime());
        System.out.println(s1);
        c.roll(Calendar.YEAR, -2);
        System.out.println(DateUtil.format(DateUtil.format1, c.getTime()));
        // 获取日历中月份最大天数
        int maxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(maxDays);
        c.set(Calendar.MONTH, 1);
        System.out.println(c.getActualMaximum(Calendar.DAY_OF_MONTH));
    }
}
