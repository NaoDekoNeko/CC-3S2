package Fase5;

public class Airport { 

    public static void main(String[] args) { 
        Flight economyFlight = new EconomyFlight("1"); 
        Flight businessFlight = new BusinessFlight("2"); 

        Passenger checha = new Passenger("Checha", true); 
        Passenger lore = new Passenger("Lore", false); 

 
        businessFlight.addPassenger(checha); 
        businessFlight.removePassenger(checha); 
        businessFlight.addPassenger(lore); 
        economyFlight.addPassenger(lore); 

        System.out.println(" Lista de pasajeros de vuelos de negocios:"); 
        for (var entry : businessFlight.getPassengersList().entrySet()) { 
            System.out.println(entry.getValue().getName()); 
        } 

        System.out.println(" Lista de pasajeros de vuelos economicos:"); 
        for (var entry : economyFlight.getPassengersList().entrySet()) { 
            System.out.println(entry.getValue().getName()); 
        } 
    } 
} 
