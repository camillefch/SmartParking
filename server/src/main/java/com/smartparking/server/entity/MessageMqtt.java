package com.smartparking.server.entity;

public class MessageMqtt {

    private String topic;
    private  String payload;
    private int qos;

    public MessageMqtt(String topic, String payload, int qos) {
        this.topic = topic;
        this.payload = payload;
        this.qos = qos;
    }

    @Override
    public String toString() {
        return "Message{" +
                "topic='" + topic + '\'' +
                ", payload='" + payload + '\'' +
                ", qos=" + qos +
                '}';
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public int getQos() {
        return qos;
    }

    public void setQos(int qos) {
        this.qos = qos;
    }
}
