package com.devices.spotdevices;

import com.sun.org.apache.xml.internal.utils.SystemIDResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Worker implements Runnable {

    private Random random = new Random();
    public List<Device> devices ;

    public Worker(List<Device> devices) {
        this.devices = devices;
    }

    public Worker() {
    }

    @Override
    public void run() {
        int randomIndex = random.nextInt(devices.size());
        try {
            post(devices.get(randomIndex));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void post(Device d) throws InterruptedException {
        Thread.sleep(10000);
        d.setStatus(random.nextInt(2));
        String command = "curl  -i \\" +
                "-H \"Accept: application/json\" \\" +
                "-H \"Content-Type:application/json\" \\ " +
                "-X POST --data " +
                " '{\"id\": \"" +
                d.getId()+
                "\", \"longitude\": \"" +
                d.getLongitude() +
                "\", \"latitude\": \"" +
                d.getLatitude() +
                "\", \"status\": \"" +
                d.getStatus() +
                "\"}' \"http://localhost:18080 \"" ;
        try {
            Process process = Runtime.getRuntime().exec(command);
            System.out.println(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    }


public class WorkerThreadPool {

    public static void main(String[] args) {
        List<Device> devices = new ArrayList<Device>();
        devices.add(new Device("1", "2.201584", "48.712560"));
        devices.add(new Device("2", "2.201600", "48.712643"));
        devices.add(new Device("3", "2.201619", "48.712719"));
        devices.add(new Device("4", "2.201649", "48.712825"));
        devices.add(new Device("5", "2.201679", "48.712899"));
        ExecutorService executor = Executors.newFixedThreadPool(1);//two threads, try setting by 1 to observe time
        System.out.println("Starting ...");
        long start = System.currentTimeMillis();
        Worker worker = new Worker(devices);
        while (true) {//worker.run is called 2 (threads started) times by two threads
            executor.submit(worker);
        }
    }
}

