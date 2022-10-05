package com.smartparking.broker.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {

    private static final String URL = "tcp://localhost:1883";

    public static void publish(String m, String topic) throws MqttException {
        MqttClient client = new MqttClient(URL, MqttClient.generateClientId());
        client.connect();
        MqttMessage message = new MqttMessage();
        message.setPayload(m.getBytes());
        client.publish(topic, message);
        client.disconnect();
    }
}