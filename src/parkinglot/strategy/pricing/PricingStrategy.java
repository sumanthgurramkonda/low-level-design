package parkinglot.strategy.pricing;

import parkinglot.model.Ticket;
import parkinglot.model.Vehicle;

import java.time.LocalDateTime;

public interface PricingStrategy {
    double getPrice(Vehicle vehicle, LocalDateTime entryTime, LocalDateTime exitTime);
}
