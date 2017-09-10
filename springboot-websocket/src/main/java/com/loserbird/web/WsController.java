package com.loserbird.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.loserbird.domain.MyMessage;
import com.loserbird.domain.MyResponse;


@Controller
public class WsController {
	
	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public MyResponse say(MyMessage message) throws Exception {
		Thread.sleep(3000);
		return new MyResponse("Welcome, " + message.getName() + "!");
	}
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@MessageMapping("/chat")
	public void handleChat(Principal principal, String msg) { 
		if (principal.getName().equals("loserbird")) {
			messagingTemplate.convertAndSendToUser("xiaoer",
					"/queue/notifications", principal.getName() + "-send:"
							+ msg);
		} else {
			messagingTemplate.convertAndSendToUser("loserbird",
					"/queue/notifications", principal.getName() + "-send:"
							+ msg);
		}
	}

}
