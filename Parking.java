package com.example.Parking_XML1;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Parking {
	  private int id ;
	    private int longitude;
	    private int latitude;
	    private int nbSpots;
	    private int spotsavailable;
	    public Parking() {}
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
	    @XmlElement 
	    public int getId() {
	        return id;
	    }

	    @XmlElement 
	    public int getLongitude() {
	        return longitude;
	    }

	    public void setLongitude(int longitude) {
	        this.longitude = longitude;
	    }
	    @XmlElement 
	    public int getLatitude() {
	        return latitude;
	    }

	    public void setLatitude(int latitude) {
	        this.latitude = latitude;
	    }
	    @XmlElement 
	    public int getNbSpots() {
	        return nbSpots;
	    }

	    public void setNbSpots(int nbSpots) {
	        this.nbSpots = nbSpots;
	    }
	    @XmlElement 
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
