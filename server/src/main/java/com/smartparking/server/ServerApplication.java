package com.smartparking.server;


import com.smartparking.server.service.Publisher;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Logger;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

    Publisher publisher = new Publisher();

    private static final Logger log = Logger.getLogger("broker");

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws MqttException {

        log.info("StartApplication...");
        publisher.publish("1", "sensors/topic");
    }


}



