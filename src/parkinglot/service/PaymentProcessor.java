package parkinglot.service;

import parkinglot.enums.PaymentStatus;
import parkinglot.model.Ticket;
import parkinglot.strategy.payment.PaymentStrategy;

public class PaymentProcessor {

    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }


    public boolean processPayment(Ticket ticket, double amount) {
        boolean paymentStatus = paymentStrategy.processPayment(ticket, amount);
        if (paymentStatus) {
            ticket.setPaymentStatus(PaymentStatus.SUCCESS);
        }else{
            ticket.setPaymentStatus(PaymentStatus.FAILED);
            System.out.println("Payment Failed for ticket : " + ticket.getTicketId());
        }
        return paymentStatus;
    }
}
