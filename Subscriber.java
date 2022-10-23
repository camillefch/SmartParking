package com.example.Parking_Json;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Subscriber 
{
    public static void main( String[] args ) throws MqttException
    {
     System.out.println("Subs start");
    	MqttClient client=new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
    	client.setCallback( new SimpleMqttCallBack() );
    	client.connect();
    	client.subscribe("Palaiseau/Parking1/Barrier");
    	client.subscribe("Palaiseau/ParkingNumber2/Slot 3");
    	 System.out.println("Subs start");
    	 //for(int i=0;i<=10;i++) {
//     	MqttClient client=new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
//     	client.setCallback( new SimpleMqttCallBack() );
//     	client.connect();
     	//client.subscribe("Palaiseau/ParkingNumber2/Slot"+Integer.toString(i));
     	
    	 //}
    }
}
