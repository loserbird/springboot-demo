package com.loserbird.springboot_activemp;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner{
	@Autowired
	JmsTemplate jmsTemplate; 
	
	 @Bean
	 public Queue queue() {
	    return new ActiveMQQueue("sample.queue");
	 }
	   
	 @Bean
	 public Topic topic() {
	    return new ActiveMQTopic("sample.topic");
	 }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
    }

	@Override
	public void run(String... args) throws Exception {
		jmsTemplate.send("my-destination", new Msg()); 
		
	}
}
