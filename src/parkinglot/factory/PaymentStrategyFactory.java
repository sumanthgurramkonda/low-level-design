package parkinglot.factory;

import parkinglot.enums.PaymentType;
import parkinglot.model.Ticket;
import parkinglot.strategy.payment.CardPayment;
import parkinglot.strategy.payment.CashPayment;
import parkinglot.strategy.payment.PaymentStrategy;
import parkinglot.strategy.payment.UPIPayment;

public class PaymentStrategyFactory {

    public static PaymentStrategy getPaymentStrategy(PaymentType paymentType) {

        return switch (paymentType) {
            case UPI -> new UPIPayment();
            case CASH -> new CashPayment();
            case CARD ->  new CardPayment();
            default -> null;
        };
    }
}
