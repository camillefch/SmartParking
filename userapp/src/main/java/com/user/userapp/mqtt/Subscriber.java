package com.user.userapp.mqtt;

import com.user.userapp.config.Mqtt;
import com.user.userapp.model.MqttSubscribeModel;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class Subscriber {

    private final static String URL = "tcp://localhost:1883";

    public static String susbcribe(String topic) throws MqttException {
        MqttClient client=new MqttClient(URL, MqttClient.generateClientId());
        SimpleMqttCallBack simpleMqttCallBack =  new SimpleMqttCallBack();
        client.setCallback(simpleMqttCallBack);
        client.connect();
        client.subscribe(topic);
        return simpleMqttCallBack.getPayload();
    }

    public static List<MqttSubscribeModel> subscribeChannel(String topic, Integer waitMillis)
            throws InterruptedException, org.eclipse.paho.client.mqttv3.MqttException {
        List<MqttSubscribeModel> messages = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Mqtt.getInstance().subscribeWithResponse(topic, (s, mqttMessage) -> {
            MqttSubscribeModel mqttSubscribeModel = new MqttSubscribeModel();
            mqttSubscribeModel.setId(mqttMessage.getId());
            mqttSubscribeModel.setMessage(new String(mqttMessage.getPayload()));
            mqttSubscribeModel.setQos(mqttMessage.getQos());
            messages.add(mqttSubscribeModel);
            countDownLatch.countDown();
        });
        countDownLatch.await(waitMillis, TimeUnit.MILLISECONDS);
        return messages;
    }
}