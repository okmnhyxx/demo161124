package com.emi.service;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * Created by emi on 2016/11/2.
 */
@Component
public class ServiceUtils {

    public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

}
