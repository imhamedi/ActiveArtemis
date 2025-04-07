package com.template.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumerB {
    @JmsListener(destination = "IMHqueue")
    public void receiveQueueMessage(String message) {
        System.out.println("B Received from Queue: " + message);
    }

}
