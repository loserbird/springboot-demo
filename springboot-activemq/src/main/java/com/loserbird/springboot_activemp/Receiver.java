package com.loserbird.springboot_activemp;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	@JmsListener(destination = "my-destination") 
	public void receiveMessage(String message) {
		System.out.println("接受到: <" + message + ">");
	}
}
