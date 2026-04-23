package com.lullaby.Calendar;

public class DayInfo {

    private int number;

    private boolean currentDay;

    private boolean change;

    public DayInfo(int number, boolean currentDay) {
        this.number = number;
        this.currentDay = currentDay;
    }

    public void show() {
        if (currentDay) {   // 当前月黑色
            if (change) {
                System.out.println(number);
            } else {
                System.out.print(number + "\t");
            }
        } else {    // 其余月份红色
            if (change) {
                System.err.println(number);
            } else {
                System.err.print(number + "\t");
            }
        }
        try {
            Thread.sleep(30L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setChange(boolean change) {
        this.change = change;
    }

    public boolean isChange() {
        return change;
    }
}
