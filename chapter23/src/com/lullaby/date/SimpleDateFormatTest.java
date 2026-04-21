package com.lullaby.date;

import java.util.Date;

public class SimpleDateFormatTest {

    public static void main(String[] args) {
//        String format1 = "yyyy-MM-dd HH:mm:ss";
//        String format2 = "yyyy/MM/dd HH:mm:ss";
        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateStr = sdf.format(date);
//        System.out.println(dateStr);

        Date yesterday = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
//        SimpleDateFormat dateFormat = new SimpleDateFormat(format2);
//        String yesterdayStr = dateFormat.format(yesterday);
//        System.out.println(yesterdayStr);

        System.out.println(DateUtil.format(DateUtil.format1, date));
        System.out.println(DateUtil.format(DateUtil.format2, yesterday));
    }
}
