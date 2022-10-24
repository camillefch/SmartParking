package com.smartparking.server.service;

import com.smartparking.server.entity.MessageMqtt;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;


public class Subscriber {


    public static MessageMqtt susbcribe(String topic, String URL) throws MqttException {

        MqttClient client=new MqttClient(URL, MqttClient.generateClientId());
        SimpleMqttCallBack callBack =new SimpleMqttCallBack();
        client.setCallback( callBack);
        client.connect();
        client.subscribe(topic);
        return callBack.getMessageMqtt();

    }
}