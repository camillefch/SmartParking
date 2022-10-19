package com.devices.generalcountdevices;






import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import java.util.Random;

@SpringBootApplication
public class GeneralCountDeviceApp implements ApplicationRunner {
    public static void main(String[] args)
    {
        SpringApplication.run(GeneralCountDeviceApp.class, args);
    }

    @Autowired
    private AppInfo appInfo;

    @Autowired
    public GeneralCountDeviceApp(AppInfo appInfo)
    {
        this.appInfo = appInfo;
    }
    private static Random random = new Random();



    @Override
    public void run(ApplicationArguments args) throws Exception, InterruptedException, MqttException {
        System.out.println(appInfo.getMaxcapacity());
        System.out.println(appInfo.getDeviceid());
        System.out.println(appInfo.getPort());
        System.out.println(appInfo.getTopic());
        while (args.equals(1)) {

  //  System.out.println(deviceid);
            int nbVehicules = random.nextInt(appInfo.getMaxcapacity());
            MqttClient client = new MqttClient("tcp://localhost:" + appInfo.getPort() , MqttClient.generateClientId());
            client.connect();
            MqttMessage message = new MqttMessage();
            message.setPayload(Integer.toString(nbVehicules).getBytes());
            client.publish(appInfo.getTopic(), message);
            client.disconnect();
            Thread.sleep(10000);

        }
    }
}

