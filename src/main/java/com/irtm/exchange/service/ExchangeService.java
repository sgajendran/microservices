package com.irtm.exchange.service;

import com.irtm.exchange.bean.ExchangeResponse;

public interface ExchangeService {

	public ExchangeResponse getExchangeRateByCurrency(String fromCurrency, String toCurrency);

}
