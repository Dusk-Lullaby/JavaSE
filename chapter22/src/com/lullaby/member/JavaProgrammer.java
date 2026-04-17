package com.lullaby.member;

public class JavaProgrammer extends SoftEngineer{

    public void communicateWithCustomer() {
//        Customer customer = new Customer() {
//            @Override
//            public void communicateBusyness() {
//                JavaProgrammer.super.analysisBusyness();
//            }
//        };

//        Customer customer = () -> super.analysisBusyness();

        Customer customer = super::analysisBusyness;
        customer.communicateBusyness();
    }
}
