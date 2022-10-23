package com.example.Parking_Json;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {
	 public static void main( String[] args ) throws MqttException, InterruptedException
	    {
		 // here we are selecting the nb of cars that are in the parking randomly every
		 
		 Parking A =new Parking();
		 A.setLatitude(100);
		 A.setNbSpots(100);
		 A.setLongitude(100);
		 //this is to choose which parking 
		 Random randID = new Random();
		 int MyrandID= randID.nextInt(2);
		 A.setId(MyrandID);
		 Random randI = new Random();
	      //here if the parking with the barriers only that count the available spots it is like the choice of the user 
		 //if he want to see the first parking or the seconde
		 if(A.getId()==1) {
			
//			for (int i=0;i<=A.getNbSpots();i++)
			 for (int i=0;i<=10;i++){
				//here we are giving random value of the cars in the parking
				int myRandInt = randI.nextInt(100);
				//here we are calculating the available spots
				int available=A.getNbSpots()-myRandInt;
		        A.setSpotsavailable(available);
		        //we are doing some parsing from integer to string
		     String y= Integer.toString(A.getSpotsavailable());
		     String m=" the available spot of Parking 1 is:"+" "+y;
			 MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
			 client.connect();
			 MqttMessage message = new MqttMessage();
			 //so variable m is the message that we are publishing
			 message.setPayload(m.getBytes());
			
			 client.publish("Palaiseau/Parking1/Barrier", message);
			 client.disconnect();
			 Thread.sleep(1000);
			}
		 }
		 //here if it is the parking with sensors
		 else {
		//we are saving an n of spot object into arraylist
			 Random rand = new Random();
			Spot spot=new Spot();
			 ArrayList<Spot> ListofSpots =new ArrayList<>();
			 for (int i=0;i<=10;i++) {
				 spot.setId(i);
				 spot.setParkingId(2);
				 //here we are puting the randomly if the spot is available or busy
				 spot.setstatus(rand.nextInt(2));
				 ListofSpots.add(spot);
				 //if the spot is available we publish every spot if available and in else we publish the spot that are busy
				 if(ListofSpots.get(i).getstatus()==0) {
					 MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
					 client.connect();
					 String m="The slot number:"+" "+ Integer.toString(ListofSpots.get(i).getId())+" "+"is available";
					 MqttMessage message = new MqttMessage();
					 message.setPayload(m.getBytes());
					 
					 client.publish("Palaiseau/ParkingNumber2/Slot"+" "+Integer.toString(ListofSpots.get(i).getId()), message);
					 client.disconnect();
					 Thread.sleep(1000); 
				 }
				 else {
					 MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
					 client.connect();
					 String m="The slot number:"+ " "+Integer.toString(ListofSpots.get(i).getId())+" "+"is busy";
					 MqttMessage message = new MqttMessage();
					 message.setPayload(m.getBytes());
					 
					 client.publish("Palaiseau/ParkingNumber2/Slot"+" "+Integer.toString(ListofSpots.get(i).getId()), message);
					 client.disconnect();
					 Thread.sleep(1000); 
				 }
			 }
			 
		 }
		 
	    }

	
}
