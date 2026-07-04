package parkinglot.model;

import parkinglot.enums.PaymentStatus;
import parkinglot.enums.PaymentType;
import parkinglot.enums.VehicleType;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private VehicleType vehicleType;
    private int floorId;
    private int spotId;
    private LocalDateTime entryTime;
    private PaymentStatus paymentStatus =  PaymentStatus.PENDING;

    public Ticket(String ticketId, VehicleType vehicleType, int floorId, int spotId, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.vehicleType = vehicleType;
        this.floorId = floorId;
        this.spotId = spotId;
        this.entryTime = entryTime;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTicketId() {
        return ticketId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getFloorId() {
        return floorId;
    }

    public int getSpotId() {
        return spotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
