package com.irtm.exchange.service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.irtm.exchange.bean.ExchangeResponse;

@Component
public class ExchangeServiceImpl implements ExchangeService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public ExchangeResponse getExchangeRateByCurrency(String fromCurrency, String toCurrency) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ExchangeResponse exchangeResponse = restTemplate
				.exchange(getUrl(fromCurrency), HttpMethod.GET, entity, ExchangeResponse.class).getBody();
		
		
		System.out.println(new Timestamp(exchangeResponse.getTime_last_updated()));
		return filterTermCurrency(exchangeResponse,toCurrency);

	}

	public String getUrl(String fromCurrency) {
		StringBuilder url = new StringBuilder("https://api.exchangerate-api.com/v4/latest/");
		url.append(fromCurrency);
		
		System.out.println(url.toString());
		return url.toString();
	}
	
	public ExchangeResponse  filterTermCurrency(ExchangeResponse conversionResponse,String toCurrency){
		Map<String, Double> requiredRates = new HashMap<String, Double>();
		requiredRates.put(toCurrency, conversionResponse.getRates().get(toCurrency));
		conversionResponse.setRates(requiredRates);
		return conversionResponse;
	}
	
}
