package com.currency.currencyconversion.controller;

import com.currency.currencyconversion.feignconfig.CurrencyExchangeProxy;
import com.currency.currencyconversion.model.CurrencyConversionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/currency-conversion")
public class ConversionController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/from/{from}/to/{to}/{quantity}")
    public CurrencyConversionBean getConversionDetails(@PathVariable String from,
                                                       @PathVariable String to,
                                                       @PathVariable BigDecimal quantity){

        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8001/currency-service/from/{from}/to/{to}", CurrencyConversionBean.class,
                uriVariables);

        CurrencyConversionBean body = responseEntity.getBody();
        return new CurrencyConversionBean(body.getId(),from,to, quantity,body.getExchangeRate(),quantity.multiply(body.getExchangeRate()),0);

    }

    @GetMapping("/from-feign/{from}/to/{to}/{quantity}")
    public CurrencyConversionBean getConversionDetailsFeign(@PathVariable String from,
                                                       @PathVariable String to,
                                                       @PathVariable BigDecimal quantity){

        CurrencyConversionBean body = proxy.getCurrencyExchangeRate(from,to);
        return new CurrencyConversionBean(body.getId(),from,to, quantity,body.getExchangeRate(),quantity.multiply(body.getExchangeRate()),0);

    }

}
