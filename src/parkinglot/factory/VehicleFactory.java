package parkinglot.factory;

import parkinglot.enums.VehicleType;
import parkinglot.model.Bike;
import parkinglot.model.Car;
import parkinglot.model.Truck;
import parkinglot.model.Vehicle;

public class VehicleFactory {

    public static Vehicle createVehicle(String number, VehicleType type){

        switch (type){
            case CAR:
                return new Car(number);
            case BIKE:
                return new Bike(number);
            case TRUCK:
                return new Truck(number);
            default:
                throw new IllegalArgumentException("Invalid Vehicle Type");
        }
    }
}
