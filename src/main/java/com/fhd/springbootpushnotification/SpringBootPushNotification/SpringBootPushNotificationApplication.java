package com.fhd.springbootpushnotification.SpringBootPushNotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootPushNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPushNotificationApplication.class, args);
	}

}
