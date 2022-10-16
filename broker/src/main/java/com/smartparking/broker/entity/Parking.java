package com.smartparking.broker.entity;



public class Parking {
    private int id ;
    private int longitude;
    private int latitude;
    private int nbSpots;
    private int spotsavailable;

    public Parking(int id, int longitude, int latitude, int nbSpots, int spotsavailable) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nbSpots = nbSpots;
        this.spotsavailable = spotsavailable;
    }

    public Parking(int id, int longitude, int latitude, int nbSpots) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nbSpots = nbSpots;
        this.spotsavailable = 0;
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

    public int getSpotsavailable() {
        return this.spotsavailable;
    }

    public void setSpotsavailable(int spotsavailable) {
        this.spotsavailable = spotsavailable;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", nbSpots=" + nbSpots +
                ", spotsavailable=" + spotsavailable +
                '}';
    }
}
