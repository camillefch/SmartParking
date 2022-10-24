package com.smartparking.server.entity;



public class Parking {
    private int id ;
    private double longitude;
    private double latitude;
    private int nbSpots;


    public Parking(int id, double longitude, double latitude, int nbSpots) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nbSpots = nbSpots;
    }


    public int getId() {
        return id;
    }



    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getNbSpots() {
        return nbSpots;
    }

    public void setNbSpots(int nbSpots) {
        this.nbSpots = nbSpots;
    }


    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", nbSpots=" + nbSpots +
                '}';
    }
}
