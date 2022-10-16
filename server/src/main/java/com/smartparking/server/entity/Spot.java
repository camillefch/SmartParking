package com.smartparking.server.entity;



public class Spot {
    private int id ;
    private int parkingId;
    private int status;

    public Spot(int id, int parkingId, int status) {
        this.id = id;
        this.parkingId = parkingId;
        this.status = status;
    }



}
