package com.emi.components;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by emi on 2016/10/25.
 */
@Component
public class MyInit2 {

    Logger logger = LoggerFactory.getLogger(MyInit2.class);

    @PostConstruct
    @Order(value = 2)
    public void doInit() {
        logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>> init 2 <<<<<<<<<<<<<<<<<<<<<<<<<<<<< ");
    }

    @PreDestroy
    public void doBye() {
        logger.info(" --- === --- === --- === bye bye === --- === --- === --- ");
    }

}
