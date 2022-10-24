package com.smartparking.server.entity;



public class Parking {
    private int id ;
    private int longitude;
    private int latitude;
    private int nbSpots;


    public Parking(int id, int longitude, int latitude, int nbSpots, int spotsavailable) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nbSpots = nbSpots;
    }

    public Parking(int id, int longitude, int latitude, int nbSpots) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nbSpots = nbSpots;
    }

    public int getId() {
        return id;
    }


    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
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
