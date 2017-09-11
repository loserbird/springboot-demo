package com.loserbird.springboot_activemp;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Producer {
   
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
   
    @Autowired
    private Queue queue;
   
    @Autowired
    private Topic topic;
   
    @Scheduled(fixedDelay=3000)//每3s执行1次
    public void send() {
       //send queue.
       this.jmsMessagingTemplate.convertAndSend(this.queue, "hi,activeMQ(queue)");
       //send topic.
       this.jmsMessagingTemplate.convertAndSend(this.topic, "hi,activeMQ(topic)");
    }
   
}
