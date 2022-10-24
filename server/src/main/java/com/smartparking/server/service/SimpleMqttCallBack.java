package com.smartparking.server.service;

import com.smartparking.server.entity.MessageMqtt;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SimpleMqttCallBack implements MqttCallback {

    public MessageMqtt getMessageMqtt() {
        return messageMqtt;
    }

    private MessageMqtt messageMqtt;

        public void connectionLost(Throwable cause) {
            // After the connection is lost, it usually reconnects here
            System.out.println("disconnect, you can reconnect");
        }

        public void messageArrived(String topic, MqttMessage message) throws Exception {
            // The messages obtained after subscribe will be executed here
            System.out.println("Received message topic:" + topic);
            System.out.println("Received message QoS:" + message.getQos());
            System.out.println("Received message content:" + new String(message.getPayload()));
            this.messageMqtt = new MessageMqtt(topic, new String(message.getPayload()), message.getQos());
        }

        public void deliveryComplete(IMqttDeliveryToken token) {
            System.out.println("deliveryComplete---------" + token.isComplete());
        }

}