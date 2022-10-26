package com.devices.generalcountdevices;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run(CentralStation cs) throws IOException {
        //clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String msg;
        int id;
        while(true) {
            msg = in.readLine();
            if(msg != null) {
                System.out.println("Read msg: "+ msg);
                if(Integer.parseInt((msg.split(";"))[1]) == 10){
                    id = Integer.parseInt((msg.split(";"))[0]);
                    cs.updateSpot(id);
                    cs.notifyChanges(id);
                }
                else {
                    System.out.println("No need to notify");
                }
            }
        }
    }
}
