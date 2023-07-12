package Fase5;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set; 

public abstract class Flight { 

    private String id; 
    protected Set<Passenger> passengers = new HashSet<>(); 

    public Flight(String id) { 
        this.id = id;
    }

    public String getId() { 
        return id; 
    } 


    public Set<Passenger> getPassengersList() { 
        return Collections.unmodifiableSet(passengers); 
    } 

    public abstract boolean addPassenger(Passenger passenger);


    public abstract boolean removePassenger(Passenger passenger); 
} 
