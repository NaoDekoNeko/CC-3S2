package Fase5;


public class PremiumFlight extends Flight{

    public PremiumFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        //solo se agrega si es VIP
        if(passenger.isVip())
            return passengers.add(passenger);
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        //se puede remover a los pasajeros
        //Precondicion: todos los pasajeros de este vuelo son VIP
        return passengers.remove(passenger);
    }
    
}
