package parkinglot.model;

import parkinglot.enums.VehicleType;

public class Vehicle {
    private String number;
    private VehicleType type;

    public Vehicle(String number, VehicleType type){
        this.number = number;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {this.number = number;}

    public VehicleType getType() {
        return type;
    }
    public void setType(VehicleType type) {
        this.type = type;
    }
}
