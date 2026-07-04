package parkinglot.model;

import parkinglot.enums.VehicleType;

import java.util.Map;

public class ParkingFloor {
    private int floorId;
    private Map<Integer, ParkingSpot> parkingSpots;

    public ParkingFloor(int floorId) {
        this.floorId = floorId;
    }

    public int getFloorId() {
        return floorId;
    }
    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }
    public void setParkingSpots(Map<Integer, ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        for(ParkingSpot parkingSpot : parkingSpots.values()){
            if(parkingSpot.getVehicleTypeAllowed()==vehicleType && parkingSpot.tryOccupy()){
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot getParkingSpot(int id) {
        return  parkingSpots.get(id);
    }
}
