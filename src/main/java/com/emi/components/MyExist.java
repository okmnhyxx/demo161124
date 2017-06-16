package com.emi.components;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by emi on 2016/10/26.
 */
@Component
@Configuration
public class MyExist implements ExitCodeGenerator {

    @Override
    public int getExitCode() {
        System.out.println(" --- === --- === --- === exit it === --- === --- === --- ");
        return -5;
    }
}
