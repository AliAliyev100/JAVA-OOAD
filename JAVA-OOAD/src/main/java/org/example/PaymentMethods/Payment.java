package org.example.PaymentMethods;

import org.example.Order;

public abstract class Payment {
    private int id ;

    public void makePayment(Order o){
        o.setStatus("Paid");
    }
}
