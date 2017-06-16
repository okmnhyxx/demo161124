package com.emi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by emi on 2016/10/27.
 */
@Configuration
public class SystemConfigs {

    @Value("${self.test.name}")
    private String name;

    @Value("${self.test.password}")
    private String password;

    @Value("${self.test.secret}")
    private List<String> secret;

    @Value("${self.test.work.year}")
    private int year;

    @Value("${self.test.work.career}")
    private String career;

    public static final String separator = "_____";



    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getSecret() {
        return secret;
    }

    public int getYear() {
        return year;
    }

    public String getCareer() {
        return career;
    }

}
