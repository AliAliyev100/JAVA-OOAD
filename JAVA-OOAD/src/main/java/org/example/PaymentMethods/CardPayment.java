package org.example.PaymentMethods;

import org.example.Order;

import java.util.Date;

public class CardPayment extends Payment{
    private String cardNumbers;
    private boolean ifVerified = false;

    public boolean getIfVerified(){
        return this.ifVerified;
    }

    CardPayment(String cardNumbers, Date expiryDate, int CVV) {
        if (verifyBankCart() == false) {
            return;
        }
        this.ifVerified = true;
    }

    public String getCardNumbers() {
        return cardNumbers;
    }

    private boolean verifyBankCart() {
        // verifies the bank card using some API calls
        return true;
    }

    public void makePayment(Order o, float amount) {
        // Check if amount exists in card through API
        super.makePayment(o);
    }
}
