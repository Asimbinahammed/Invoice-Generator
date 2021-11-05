package com.bridgelab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Purpose : To create new hashmap for each user ride and map each ride by id
 */
public class RideRepository {
    Map<String ,ArrayList<Ride>> userRide = null;

    public RideRepository(){
        this.userRide = new HashMap<>();
    }

    /**
     * Purpose : Adding ride by id into list
     * @param userId
     * @param rides
     */
    public void addRides(String userId, Ride[] rides) {
        ArrayList<Ride> rideList = this.userRide.get(userId);
        if (rideList == null){
            this.userRide.put(userId, new ArrayList<>(Arrays.asList(rides)));
        }
    }

    public Ride[] getRides(String userId) {
        return this.userRide.get(userId).toArray(new Ride[0]);
    }
}
