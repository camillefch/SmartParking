package com.devices.generalcountdevices;
import java.net.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.io.*;
import javax.json.*;
import javax.json.JsonValue.ValueType;
import javax.json.stream.JsonGenerator;

public class CentralStation {

    private int availableSpots;
    private boolean[] spots;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private static final int PORT = 16160;

    public static void main(String[] args) {
        CentralStation cs = new CentralStation();
        try{
            cs.start(PORT);
        }
        catch(IOException e) {
            System.out.println("Something happened initializing the P1 Central Station");
            System.out.println(e.getMessage());
        }
    }

    public CentralStation() {
        availableSpots = 100;
        spots = new boolean[100];
        for(boolean spot : spots ) {
            spot = true; //At the beginning all spots are available
        }
    }

    public void start(int port) throws IOException {
        //Server for the Camera devices
        serverSocket = new ServerSocket(port);
        System.out.println("P1 Central  Station Server started.");
        System.out.println("This parking has "+ availableSpots + " available spots.");
        while(true) {
            //new ClientHandler(serverSocket.accept()).start();
            ClientHandler ch = new ClientHandler(serverSocket.accept());
            ch.start();
            ch.run();
            ch.run(this);
        }
        //Client for the Proxy
        clientSocket = new Socket("localhost",16161);
        out = new PrintWriter(clientSocket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("P1 started as client for the proxy.");
    }

    public void updateSpot(int idCam) {
        boolean temp = spots[idCam];
        if(temp) {
            //The spot was available but not anymore
            availableSpots--;
        }
        else {
            //The spot was not available and now it is
            availableSpots++;
        }
        spots[idCam]=!spots[idCam];
        System.out.println("There is now " + availableSpots+ " available spots.");
    }

    public void notifyChanges(int idCam) throws FileNotFoundException {
        int camStatus;
        if(spots[idCam]){
            camStatus = 1;
        }
        else{
            camStatus = 0;
        }
        String msg = idCam+";"+ camStatus+";"+availableSpots;
        out.println(msg);
        System.out.println("Notified");
    }
}