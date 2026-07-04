package parkinglot.service;

import parkinglot.enums.PaymentType;
import parkinglot.enums.VehicleType;
import parkinglot.factory.PaymentStrategyFactory;
import parkinglot.model.ParkingFloor;
import parkinglot.model.ParkingSpot;
import parkinglot.model.Ticket;
import parkinglot.model.Vehicle;
import parkinglot.strategy.payment.PaymentStrategy;
import parkinglot.strategy.pricing.PricingStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {

    private final Map<Integer, ParkingFloor> floors = new HashMap<>();
    private final Map<String, Ticket> activeTickets = new HashMap<>();
    private PricingStrategy pricingStrategy;

    private ParkingLot() {
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime) {

        for(ParkingFloor floor : floors.values()) {
            ParkingSpot spot = floor.findAvailableSpot(vehicle.getType());
            if(spot != null) {
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle.getType(), floor.getFloorId(), spot.getId(), entryTime);
                activeTickets.put(ticket.getTicketId(), ticket);
                return ticket;
            }
        }
        return null;
    }


    public void unParkVehicle(String ticketId, LocalDateTime exitTime, PaymentType paymentType) {
        Ticket ticket = activeTickets.get(ticketId);

        PaymentStrategy strategy = PaymentStrategyFactory.getPaymentStrategy(paymentType);
        if(strategy != null) {
            PaymentProcessor processor = new PaymentProcessor(strategy);
            double amount = pricingStrategy.getPrice(ticket.getVehicleType(),ticket.getEntryTime() , exitTime);
            boolean paid = processor.processPayment(ticket,0d);
            if(!paid){
                System.out.println("Payment failed");
                return;
            }
            ParkingSpot spot = floors.get(ticket.getFloorId()).getParkingSpot(ticket.getSpotId());
            spot.vacate();
            activeTickets.remove(ticketId);

        }
    }

}
