package com.lzb.camel.camel;

import org.apache.camel.Exchange;

public interface IntegrationInterface {

	public Exchange integrationLogic(Exchange oldExchange, Exchange newExchange);
	
}
