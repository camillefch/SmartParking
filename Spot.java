package com.example.Parking_Json;

public class Spot {
	 private int id ;
	    private int parkingId;
	    private int status;
	    public Spot(){}
	    public Spot(int id, int parkingId, int status) {
	        this.id = id;
	        this.parkingId = parkingId;
	        this.status = status;
	    }
	    public int getId() {
	    	return this.id;
	    }
	    public void setId(int id) {
	    	this.id=id;
	    }
	    public int getParkingId() {
	    	return this.parkingId;
	    }
	    public void setParkingId(int parkingId) {
	    	this.parkingId=parkingId;
	    }
	    public int getstatus() {
	    	return this.id;
	    }
	    public void setstatus(int status) {
	    	this.status=status;
	    }
}
