package parkinglot.strategy.payment;

import parkinglot.model.Ticket;

public interface PaymentStrategy {

    public boolean processPayment(Ticket ticket, double amount);
}
