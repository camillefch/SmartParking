package com.user.userapp.controller;


import com.user.userapp.model.MqttSubscribeModel;
import com.user.userapp.mqtt.Subscriber;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("availablespots")
public class ParkingsStatusController {


    @GetMapping("/Palaiseau/nbAvailableSpots")
    public String getTotalAvailableSpots() throws MqttException, InterruptedException {
        System.out.println("nb spots available = ");
        String topic = "/Palaiseau/nbAvailableSpots";
        List<MqttSubscribeModel> mqttSubscribeModelList = Subscriber.subscribeChannel(topic, 100);
        for(MqttSubscribeModel m : mqttSubscribeModelList){
            System.out.println("nb spots available = " + m.getMessage());
        }

        return "";

    }

    @GetMapping("/Palaiseau/{parkingid}/nbAvailableSpots")
    public String getAvailableSpotsOnSpecificParking(@PathVariable String parkingid) throws MqttException {
        String topic = "/Palaiseau/"+parkingid+"/nbAvailableSpots";
        return Subscriber.susbcribe(topic);

    }

    @GetMapping("/Palaiseau/{parkingid}/{spotId}/status")
    public String getAvailableSpotsOnSpecificParking(@PathVariable String parkingid, @PathVariable int spotId) throws MqttException {
        String topic = "/Palaiseau/"+parkingid+"/"+spotId+"/status";
        return Subscriber.susbcribe(topic);
    }


}
