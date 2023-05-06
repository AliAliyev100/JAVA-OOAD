package org.example.People;

import org.example.Order;

public class Courier extends Staff{

    private boolean isDelivering;

    public boolean isDelivering() {
        return isDelivering;
    }

    public void takeOrder(Order o){
        isDelivering = true;
        o.setStatus("Delivering");
    }

    public void finishOder(Order o){
        isDelivering = false;
        o.setStatus("Finished");
    }


}
