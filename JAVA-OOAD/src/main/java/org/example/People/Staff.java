package org.example.People;

import org.example.Order;

public abstract class Staff {
    private int id;
    private String fullName;
    private int yearsOfExperience;
    private boolean isOnline;

    public void changerOrderStatus(Order o, String status){
        o.setStatus(status);
    }
}
