package com.lullaby.Calendar;

public class DayInfo {

    private int number;

    private boolean currentDay;

    public DayInfo(int number, boolean currentDay) {
        this.number = number;
        this.currentDay = currentDay;
    }

    public void show() {
        if (currentDay) {   // 当前月黑色
            System.out.print(number + "\t");
        } else {    // 其余月份红色
            System.err.print(number + "\t");
        }
        try {
            Thread.sleep(30L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
