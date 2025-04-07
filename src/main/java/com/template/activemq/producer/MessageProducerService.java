package com.template.activemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendToQueue(String queueName, String message) {
        jmsTemplate.convertAndSend(queueName, message);
        System.out.println("Sent to Queue: " + message);
    }

    public void sendToTopic(String topicName, String message) {
        jmsTemplate.setPubSubDomain(true); // obligatoire pour un topic
        jmsTemplate.convertAndSend(topicName, message);
        System.out.println("Sent to Topic: " + message);
    }
}
