package com.example.Parking_Json;

import java.util.Random;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {
	 public static void main( String[] args ) throws MqttException
	    {
		 Parking A =new Parking();
		 A.setLatitude(100);
		 A.setNbSpots(100);
		 A.setLongitude(100);
		 //this is to choose which parking 
		 Random randID = new Random();
		 int MyrandID= randID.nextInt(2);
		 A.setId(MyrandID);
		 // this is to select the random available spots
		 Random randI = new Random();
	        int myRandInt = randI.nextInt(100);
	        A.setSpotsavailable(myRandInt);
		 if(A.getId()==1) {
			
		     String y= Integer.toString(A.getSpotsavailable());
		     String m=" the available spot of Parking 1 is";
			 MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
			 client.connect();
			 MqttMessage message = new MqttMessage();
			 message.setPayload(y.getBytes());
			 client.publish("iot_data", message);
			 client.disconnect(); 
		 }
		 else {
			 MqttClient client1 = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
			 client1.connect();
			 MqttMessage message1 = new MqttMessage();
			 message1.setPayload("this is the parking with sensor".getBytes());
			 client1.publish("iot_data", message1);
			 client1.disconnect(); 
			 System.out.println("This is not the parking 1");
		 }
		 
	    }
}
