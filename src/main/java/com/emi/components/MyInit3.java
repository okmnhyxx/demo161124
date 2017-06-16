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
@Order(value = 3)
public class MyInit3 implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>> init 3 <<<<<<<<<<<<<<<<<<<<<<<<<<<<< ");
    }
}
