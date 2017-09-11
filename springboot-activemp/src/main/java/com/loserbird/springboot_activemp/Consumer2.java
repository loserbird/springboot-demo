package com.loserbird.springboot_activemp;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {
    @JmsListener(destination = "sample.topic")
    public void receiveQueue(String text) {
       System.out.println("Consumer2="+text);
    }
}
