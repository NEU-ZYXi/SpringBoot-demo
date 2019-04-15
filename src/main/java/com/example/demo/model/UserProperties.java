package com.example.demo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user")
public class UserProperties {

    private Integer age;
    private String nick;

    public Integer getAge() {
        return age;
    }

    public String getNick() {
        return nick;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
