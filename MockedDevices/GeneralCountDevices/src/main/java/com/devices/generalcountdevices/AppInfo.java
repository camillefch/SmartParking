package com.devices.generalcountdevices;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "config")
public class AppInfo {

    private String deviceid;
    private int maxcapacity;
    private int port;
    private String topic;

}
