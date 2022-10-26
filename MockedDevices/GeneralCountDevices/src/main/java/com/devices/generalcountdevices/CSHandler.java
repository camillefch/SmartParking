package com.devices.generalcountdevices;

public class CSHandler extends Thread{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public CSHandler(Socket socket){
        this.clientSocket = socket;
    }

    public void run(ProxyP1 proxy){
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String msg;
        int id;
        int status;
        int total;
        while(true) {
            msg = in.readLine();
            if (msg != null) {
                System.out.println("Read msg from CS: "+ msg);
                id = (msg.split(";"))[0];
                status = (msg.split(";"))[1];
                total = (msg.split(";"))[2];
                proxy.publish(id, status, total);
            }
            else{
                System.out.println("Something happened with the msg received from CS");
            }
        }
    }
}