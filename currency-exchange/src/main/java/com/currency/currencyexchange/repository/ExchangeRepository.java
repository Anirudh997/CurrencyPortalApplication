package com.currency.currencyexchange.repository;

import com.currency.currencyexchange.model.CurrencyExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<CurrencyExchangeRate,Integer> {


    CurrencyExchangeRate findByFromAndTo(String from,String to);
}
