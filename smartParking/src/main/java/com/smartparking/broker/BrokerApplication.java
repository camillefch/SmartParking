package com.smartparking.broker;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Logger;

@SpringBootApplication
public class BrokerApplication implements CommandLineRunner {

    private static final Logger log = Logger.getLogger("broker");

    public static void main(String[] args) {
        SpringApplication.run(BrokerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("StartApplication...");
    }


}



