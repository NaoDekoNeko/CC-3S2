package Fase5;

public class EconomyFlight extends Flight{

    public EconomyFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passengers.putIfAbsent(passenger.getName(),passenger) == null;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if (!passenger.isVip()) { 
            return passengers.remove(passenger.getName()) != null;
        }
        return false;
    }

}
