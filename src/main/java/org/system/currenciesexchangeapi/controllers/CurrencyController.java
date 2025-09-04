package org.system.currenciesexchangeapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.system.currenciesexchangeapi.Services.CurrencyService;

import java.util.Currency;
import java.util.Map;
import java.util.Objects;

@RestController
public class CurrencyController {
    @Autowired
    CurrencyService currencyService = new CurrencyService();
    @GetMapping("/{from}/{to}/{amount}")
    public double getResult(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("amount") float amount)
    {
        return currencyService.getExchangeResult(from, to, amount);
    }
}
