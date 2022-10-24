package com.smartparking.server;


import com.smartparking.server.devices.GeneralCountDeviceUtility;
import com.smartparking.server.service.Publisher;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Logger;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

    GeneralCountDeviceUtility generalCountDeviceUtility ;

    private static final Logger log = Logger.getLogger("server");

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws MqttException {

        log.info("StartApplication...");
        generalCountDeviceUtility = new GeneralCountDeviceUtility();
        generalCountDeviceUtility.susbcribe("/0001/NbVehicules" , "tcp://localhost:10883");

    }


}



