package com.fhd.springbootpushnotification.SpringBootPushNotification.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PushNotificationRequest {


	private String title;
    private String message;

    public void setTopic(String topic) {
        this.topic = topic;
    }

    private String topic;
    private String token;

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getTopic() {
        return topic;
    }

    public String getToken() {
        return token;
    }
}