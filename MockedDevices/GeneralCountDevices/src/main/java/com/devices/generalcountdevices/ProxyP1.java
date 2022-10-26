package com.devices.generalcountdevices;

public class ProxyP1 {

    private int cameraId;
    private int camerastatus; //0 or 1
    private int totalAvailableSpots;
    private ServerSocket serverSocket;
    private static final int PORT = 16161;
    //private static final String totalTopic = "/0001/NbVehicules";
    private static final String totalTopic = "Palaiseau/1/availablespots";

    public static void main(String[] args) {
        ProxyP1 proxy = new ProxyP1();
        try{
            proxy.start(PORT);
        }
        catch (IOException e){
            System.out.println("Something happened initializing the proxy.");
            System.out.println(e.getMessage());
        }
    }

    public ProxyP1(){
        cameraId = -1;
        camerastatus = -1;
        totalAvailableSpots = -1;
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Proxy started.");
        CSHandler csh = new CSHandler(serverSocket.accept());
        csh.start();
        csh.run();
        csh.run(this);
    }

    public void publish(int camId, int camStatus, int totalAS){
        /*MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
        client.connect();
        //Total Available Spots Message
        MqttMessage totalMessage = new MqttMessage();
        totalMessage.setPayload(totalAS.getBytes());
        client.publish(totalTopic, totalMessage);
        //Spot Message
        MqttMessage spotMessage = new MqttMessage();
        spotMessage.setPayload(totalAS.getBytes());
        client.publish("Palaiseau/1/"+camId+"/"+camStatus, spotMessage);

        client.disconnect();
        System.out.println("Messages published");*/
        System.out.println("Ready to publish in MQTT: "+ "camId = "+ camId +" camstatus = "+ camStatus + " total = "+ totalAS);
    }

}