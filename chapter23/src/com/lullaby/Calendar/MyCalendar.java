package com.lullaby.Calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MyCalendar {

    public static void main(String[] args) {
        int year = 2021;
        int month = 1;
        show(year, month);
    }

    private static void show(int year, int month) {
        int totalDays = 42; // 日历显示总天数
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // 获取设置的日历的月份第一天是周几
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(week);
        // 获取本月最大天数
        int currentMonthMaxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.roll(Calendar.MONTH, -1);  // 表示上一月
        // 获取上一月最大天数
        int prevMonthMaxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 计算上一月显示天数
        int prevMonthDisplayDays = week == 1 ? 6 : week - 2;
        // 计算下月显示天数
        int nextMonthDisplayDays = totalDays - prevMonthDisplayDays - currentMonthMaxDays;
        List<DayInfo> days = new ArrayList<>();
        int prevMonthStartDay = prevMonthMaxDays - prevMonthDisplayDays + 1;
        for (int i = prevMonthStartDay; i <= prevMonthMaxDays; i++) {
            days.add(new DayInfo(i, false));
        }
        // 当前月所有天数全部展示
        for (int i = 1; i <= currentMonthMaxDays; i++) {
            days.add(new DayInfo(i, true));
        }
        // 下一月显示天数
        for (int i = 1; i <= nextMonthDisplayDays; i++) {
            days.add(new DayInfo(i, false));
        }
        System.out.println(year + "年" + (month + 1) + "月");
        System.out.println("一\t二\t三\t四\t五\t六\t日");
        for (int i = 0; i < days.size(); i++) {
            DayInfo info = days.get(i);
            info.show();
            if (i % 7 == 6) {
                System.out.println(days.get(i));
            }
        }
    }
}
