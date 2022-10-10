package com.currency.currencyexchange.controller;

import com.currency.currencyexchange.model.CurrencyExchangeRate;
import com.currency.currencyexchange.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-service")
public class CurrencyExchangeController {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchangeRate getCurrencyExchangeRate(@PathVariable String from, @PathVariable String to){

        return exchangeRepository.findByFromAndTo(from, to);

        //CurrencyExchangeRate(1001L,from,to, BigDecimal.valueOf(71));
    }

    @PostMapping("/save/from/{from}/to/{to}/er/{exchangeRate}")
    public String saveExchangeRate(@PathVariable String from, @PathVariable String to, @PathVariable Integer exchangeRate){
        CurrencyExchangeRate currencyExchangeRate = new CurrencyExchangeRate();
        currencyExchangeRate.setFrom(from);
        currencyExchangeRate.setTo(to);
        currencyExchangeRate.setExchangeRate(BigDecimal.valueOf(exchangeRate));
        exchangeRepository.save(currencyExchangeRate);
        return "record inserted successfully";
    }
}
