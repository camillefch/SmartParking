package com.smartparking.server.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;


public class Subscriber {

    private final static String URL = "tcp://localhost:1883";

    public static void susbcribe(String topic) throws MqttException {

        MqttClient client=new MqttClient(URL, MqttClient.generateClientId());
        client.setCallback( new SimpleMqttCallBack() );
        client.connect();
        client.subscribe(topic);
    }
}