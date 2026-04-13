package com.Sonnet.electrical_appliances;

public class Person {

    public void check(ElectricalAppliances ea) {
        if (ea instanceof AirConditioner) {
            ((AirConditioner)ea).turnAir();
        } else if (ea instanceof Fan) {
            ((Fan)ea).turnFan();
        } else if (ea instanceof TV) {
            ((TV)ea).playVideo();
        }
    }
}
