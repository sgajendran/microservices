package com.irtm.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.irtm.exchange.bean.ExchangeResponse;
import com.irtm.exchange.service.ExchangeService;


@RestController
public class ExchangeController {

	@Autowired
	public ExchangeService exchangeService;
	
	@GetMapping("/exchangerate/{fromCurrency}/{toCurrency}")
	public  ExchangeResponse getCurrency(@PathVariable("fromCurrency") String fromCurrency,@PathVariable("toCurrency") String toCurrency){
	
		System.out.println(fromCurrency+","+toCurrency);
				return exchangeService.getExchangeRateByCurrency(fromCurrency,toCurrency);
	}
}
