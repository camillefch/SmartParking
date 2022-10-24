package com.smartparking.server.devices;


import com.smartparking.server.service.Publisher;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotDevicesUtility {

    Publisher publisher = new Publisher();

    //listen to 18080
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void updateStatus(@RequestBody SpotDevice spotDevice) throws MqttException {

        //TODO : Finding the right parking from the location
        String parkingId = "5" ;

        //Publish
        String topic = "Palaiseau/" + parkingId +"/" + spotDevice.getId() +"/status";
        publisher.publish(Integer.toString(spotDevice.getStatus()) , topic);
        System.out.println("published in : " + topic );


    }

}
