package com.lullaby.member;

public class Computer {

    private Printer printer;

    public Computer(Printer printer) {
        this.printer = printer;
    }

    public void print(String info) {
//        Printable printable = new Printable() {
//            @Override
//            public void print(String info) {
//                   printer.print(info);
//            }
//        };
//        printable.print(info);

//        Printable printable = information -> this.printer.print(information);

        Printable printable = printer::print;
        printable.print(info);

    }
}
