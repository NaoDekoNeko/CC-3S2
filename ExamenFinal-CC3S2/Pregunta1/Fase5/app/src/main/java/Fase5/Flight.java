package Fase5;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public abstract class Flight { 

    private String id; 
    protected Map<String, Passenger> passengers = new HashMap<>(); 

    public Flight(String id) { 
        this.id = id;
    }

    public String getId() { 
        return id; 
    } 


    public Map<String, Passenger> getPassengersList() { 
        return Collections.unmodifiableMap(passengers); 
    } 

    public abstract boolean addPassenger(Passenger passenger);


    public abstract boolean removePassenger(Passenger passenger); 
} 
