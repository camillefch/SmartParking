package com.smartparking.server.devices;


import com.opencsv.CSVReader;
import com.smartparking.server.entity.MessageMqtt;
import com.smartparking.server.entity.Parking;
import com.smartparking.server.service.Publisher;
import org.eclipse.paho.client.mqttv3.*;

import java.io.FileReader;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.List;

public class GeneralCountDeviceUtility  {

    public static void subscribe(String topic, String URL) throws MqttException {

        MqttClient client=new MqttClient(URL, MqttClient.generateClientId());
        MqttCallBackGeneralCount callBack =new MqttCallBackGeneralCount();
        client.setCallback(callBack);
        client.connect();
        client.subscribe(topic);



    }


}

class MqttCallBackGeneralCount implements MqttCallback {

    public MqttMessage getMqttMessage() {
        return mqttMessage;
    }

    private MqttMessage mqttMessage = new MqttMessage() ;

    public void connectionLost(Throwable cause) {
        // After the connection is lost, it usually reconnects here
        System.out.println("disconnect, you can reconnect");
    }

    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // The messages obtained after subscribe will be executed here
        System.out.println("Received message topic:" + topic);
        System.out.println("Received message QoS:" + message.getQos());
        System.out.println("Received message content:" + new String(message.getPayload()));

        mqttMessage =message;
        transmit();

    }

    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("deliveryComplete---------" + token.isComplete());
    }

    private void transmit() throws MqttException {
        //Find Parking. For now we assume it's the 3rd
        Parking p3 = new Parking(3, 48.711545,2.203357, 400);
        System.out.println(Integer.parseInt(new String(mqttMessage.getPayload())));
        //Compute available spots
        int nbavailablespots = p3.getNbSpots()- Integer.parseInt(new String(mqttMessage.getPayload()));
        System.out.println("nb spots : " + nbavailablespots);
        //Publish
        Publisher publisher = new Publisher();
        publisher.publish(Integer.toString(nbavailablespots), "Palaiseau/" + p3.getId() + "/nbavailablespots");
        System.out.println("Published in : " );
    }

}