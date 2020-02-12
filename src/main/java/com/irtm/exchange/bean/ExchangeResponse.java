package com.irtm.exchange.bean;

import java.time.LocalDate;
import java.util.Map;

public class ExchangeResponse {

	private String base;
	private LocalDate date;
	private long time_last_updated;
	private Map<String, Double> rates;
	
	public ExchangeResponse() {
	}
	
	public ExchangeResponse(String base, LocalDate date, long time_last_updated, Map<String, Double> rates) {
		super();
		this.base = base;
		this.date = date;
		this.time_last_updated = time_last_updated;
		this.rates = rates;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public long getTime_last_updated() {
		return time_last_updated;
	}
	public void setTime_last_updated(long time_last_updated) {
		this.time_last_updated = time_last_updated;
	}
	public Map<String, Double> getRates() {
		return rates;
	}
	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "ConversionResponse [base=" + base + ", date=" + date + ", time_last_updated=" + time_last_updated
				+ ", rates=" + rates + "]";
	}
	
}
