package com.currency.limitservice.controller;

import com.currency.limitservice.config.ConfigurationProps;
import com.currency.limitservice.model.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    private ConfigurationProps configuration;

    @GetMapping("/limit-service")
    public LimitConfiguration retrievelimitconfiguration(){

        //return new LimitConfiguration(1,100); --> Hard Coding
        return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum()); // -->through properties

    }

}
