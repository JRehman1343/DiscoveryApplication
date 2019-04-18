package com.qvc.service.discovery.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "moveit-config")
public class MoveItConfig {
	private String host;
	private String userName;
	private String password;
	private String localFileDirectory;
	private String destination;
}
