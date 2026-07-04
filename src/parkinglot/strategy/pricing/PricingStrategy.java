package parkinglot.strategy.pricing;

import parkinglot.enums.VehicleType;
import parkinglot.model.Ticket;
import parkinglot.model.Vehicle;

import java.time.LocalDateTime;

public interface PricingStrategy {
    double getPrice(VehicleType vehicle, LocalDateTime entryTime, LocalDateTime exitTime);
}
