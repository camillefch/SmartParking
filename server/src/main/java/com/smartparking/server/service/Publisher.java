package com.smartparking.server.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;



public class Publisher {

    private String URL = "tcp://localhost:1883";

    public Publisher() {
    }

    public void publish(String m, String topic) throws MqttException {
        MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
        client.connect();
        MqttMessage message = new MqttMessage();
        message.setPayload(m.getBytes());
        client.publish(topic, message);
        client.disconnect();
    }
}