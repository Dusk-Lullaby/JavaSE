package com.lullaby.date;

import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        Date now = new Date();  // 获取计算机系统当前时间
        System.out.println(now);
        // 获取系统当前时间（数字形式）
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        System.out.println(date);
        long dateTime = date.getTime(); // 获取日期对象中的数字时间
        System.out.println(time - dateTime);
        long yesterday = time - 24 * 60 * 60 * 1000;
        Date yesterdayDate = new Date(yesterday);   // 昨天
        boolean before = yesterdayDate.before(now); // 昨天是否在今天之前
        boolean after = yesterdayDate.after(now);   // 昨天是否在今天之后
        System.out.println(before);
        System.out.println(after);
        // 2026/4/21 22:21:23   2026-4-21 22:21:23  2026年4月21日22时21分23秒
    }
}
