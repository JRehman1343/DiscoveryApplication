package com.qvc.service.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qvc.service.discovery.config.MoveItConfig;

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class DiscoveryApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DiscoveryApplication.class, args);
	}
}
@RefreshScope
@RestController
class MessageRestController {

	@Value("${messageOne:hello DefaultOne}")
	private String messageOne;
	@Value("${messageTwo:hello DefaultTwo}")
	private String messageTwo;

	@Autowired
	private MoveItConfig moveItConfig;

	@RequestMapping("/messages")
	String getMessage() {
		return moveItConfig.getDestination();
	}

	//    @RequestMapping("/messages")
	//    Configurations getMessage() {
	//        Message message = new Message();
	//    	message.setMessageOne(messageOne);
	//    	message.setMessageTwo(messageTwo);
	//        return message;
	//    }
}