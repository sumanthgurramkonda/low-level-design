package parkinglot.strategy.payment;

import parkinglot.model.Ticket;

public class UPIPayment implements PaymentStrategy {

    public boolean processPayment(Ticket ticket, double amount){

        return true;
    }
}
