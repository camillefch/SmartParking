package com.smartparking.broker.sensors;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.concurrent.Callable;

public class ParkingTest implements Callable<Void> {
    public static final String TOPIC = "parking";
    private final IMqttClient client;


    public ParkingTest(IMqttClient client) {
        this.client = client;
    }

    @Override
    public Void call() throws Exception {
        if ( !client.isConnected()) {
            return null;
        }
        MqttMessage msg = nbavailablespots();
        msg.setQos(0);
        msg.setRetained(true);
        client.publish(TOPIC,msg);
        return null;
    }

    private MqttMessage nbavailablespots() {
        //TODO : get information for parkings spots
        return null;
    }
}