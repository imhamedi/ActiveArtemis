package com.template.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicSubscriberB {

    @JmsListener(destination = "IMHtopic", containerFactory = "topicListenerFactory")
    public void receiveTopicMessage(String message) {
        System.out.println("Topic B Received from Topic: " + message);
    }
}
