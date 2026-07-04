package parkinglot.strategy.payment;

import parkinglot.model.Ticket;

public class CardPayment implements PaymentStrategy {

    public boolean processPayment(Ticket ticket, double amount){

        return true;
    }
}
