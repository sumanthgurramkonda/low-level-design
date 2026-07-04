package parkinglot.model;

import parkinglot.enums.VehicleType;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {
    private int id;
    private VehicleType vehicleTypeAllowed;
    private AtomicBoolean occupy = new AtomicBoolean(false);

    public ParkingSpot(VehicleType vehicleTypeAllowed, int id){
        this.vehicleTypeAllowed = vehicleTypeAllowed;
        this.id = id;
    }

    public boolean isOccupied(){
        return occupy.get();
    }

    public boolean tryOccupy(){
        return occupy.compareAndSet(false, true);
    }

    public void vacate(){
        occupy.set(false);
    }

    public int getId() {
        return id;
    }

    public VehicleType getVehicleTypeAllowed() {
        return vehicleTypeAllowed;
    }

    public void setVehicleTypeAllowed(VehicleType vehicleTypeAllowed) {
        this.vehicleTypeAllowed = vehicleTypeAllowed;
    }

    public void setId(int id) {
        this.id = id;
    }
}
