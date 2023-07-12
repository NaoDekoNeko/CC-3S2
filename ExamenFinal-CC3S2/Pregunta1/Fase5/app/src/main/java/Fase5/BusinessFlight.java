package Fase5;

public class BusinessFlight extends Flight{

    public BusinessFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        if (passenger.isVip()) { 
            return passengers.putIfAbsent(passenger.getName(),passenger) == null;
        }
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return false;
    }
}