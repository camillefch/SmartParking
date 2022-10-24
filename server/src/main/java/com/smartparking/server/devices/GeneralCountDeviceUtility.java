package com.smartparking.server.devices;


import com.smartparking.server.entity.Parking;
import com.smartparking.server.service.Publisher;
import com.smartparking.server.service.Subscriber;

import java.security.PrivateKey;

public class GeneralCountDeviceUtility {
    private Subscriber subscriber;
    private Publisher publisher;




    private String MapDeviceToParking(String deviceID){
        return "";
    }

    private int  computeAvailableSpots(Parking parking, int nbVehicules){
        return parking.getNbSpots() - nbVehicules;
    }

}