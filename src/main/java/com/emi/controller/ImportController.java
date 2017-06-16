package com.emi.controller;

import com.emi.dto.OrderImportDetailResponse;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by emi on 2016/10/27.
 */
@Controller
@RequestMapping(value = "/api/import")
public class ImportController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OrderImportDetailResponse detail(@Param("id") long importId) {

        return new OrderImportDetailResponse();
    }




}
