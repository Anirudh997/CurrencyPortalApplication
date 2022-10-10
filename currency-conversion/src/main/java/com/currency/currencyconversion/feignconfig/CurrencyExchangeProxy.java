package com.currency.currencyconversion.feignconfig;

import com.currency.currencyconversion.model.CurrencyConversionBean;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "exchange-service")
@RibbonClient(name = "exchange-service") //Client load balancing across instances
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-service/from/{from}/to/{to}")
    CurrencyConversionBean getCurrencyExchangeRate(@PathVariable String from, @PathVariable String to);

}
