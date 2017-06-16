package com.emi.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by emi on 2016/10/25.
 */
@Component
@Configuration
@Order(value = 1)
public class MyInit1 implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(strings);
        System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>> init 1 <<<<<<<<<<<<<<<<<<<<<<<<<<<<< ");
//        如果设置SpringApplication.setRegisterShutdownHook(false)，则自动重启将不起作用
//        application.setRegisterShutdownHook(false);
    }
}
