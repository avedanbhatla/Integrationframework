package com.lzb.camel.camel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lzb.hr.beans.objectbeanlist.EmployeeBenefitsList;
import com.lzb.hr.beans.objectbeanlist.Employees;
import com.lzb.hr.beans.objectbeans.Employee;
import com.lzb.hr.beans.objectbeans.EmployeeBenefits;
import com.lzb.hr.beans.vendorbeanlist.EquifaxList;
import com.lzb.hr.beans.vendorbeans.Equifax;

@Component(value = "")
public class EquifaxIntegrationRouteBuilder extends RouteBuilder implements IntegrationInterface{

	
	 @Value("${route.from.equifax.ws1}")
	    String ws1Url;
	    
	    @Value("${route.from.equifax.ws2}")
	    String ws2Url;
	    
	    @Value("${route.from.equifax.endpoint}")
	    String endpointURL1;
	    
	    @Value("${route.from.equifax.bean1}")
	    String bean1;
	    
	    @Value("${route.from.equifax.bean2}")
	    String bean2;
	    
	    @Value("${route.from.equifax.vendorBean}")
	    String vendorBean;
	    
	   
	    
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(endpointURL1);
		
restConfiguration();
    	
    	rest(endpointURL1)
        .get("/").description("").outType(Class.forName(vendorBean))
        .route()
        .setHeader("Content-Type", constant("application/json"))
        .setHeader("Accept", constant("application/json"))
        .to(ws1Url)
        .unmarshal()
        .json(JsonLibrary.Jackson,Class.forName(bean1))
        .enrich("direct:Web-service3", new AggregationStrategy() {
			
			@Override
			public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
				// TODO combines to messages and business exception logic (if any)
				
				return integrationLogic(oldExchange,newExchange);
				
			}
		})
        .log("before marshal to pojo: ${body}")
        .marshal()
        .json(JsonLibrary.Jackson,Class.forName(vendorBean))
        .log("Final data: ${body}")
        .to("log:result")
        
        .endRest();

		
    	
    	from("direct:Web-service3")
		        .transform().simple("${null}")
		        .setHeader(Exchange.HTTP_METHOD, constant("GET"))
		        .removeHeaders("CamelHttp*")
		        .to(ws2Url)
		        .unmarshal()
		        .json(JsonLibrary.Jackson,Class.forName(bean2))
		.to("log:result");
		
	}


	@Override
	public Exchange integrationLogic(Exchange oldExchange, Exchange newExchange) {
		// TODO Auto-generated method stub
		Employees emp = oldExchange.getIn().getBody(Employees.class);
		EmployeeBenefitsList empB = newExchange.getIn().getBody(EmployeeBenefitsList.class);
		
		HashMap<Integer,Equifax> map = new HashMap<Integer,Equifax>();
		List<Equifax> list = new ArrayList<Equifax>();
		
		
		for(Employee e: emp.getEmployeesList()){
			
			for(EmployeeBenefits b: empB.getEmployeesList()){
			
				
				map.put(e.getId(), new com.lzb.hr.beans.vendorbeans.Equifax(Integer.toString(e.getId()), e.getFirstName(), e.getLastName(), b.getDentalBen(), b.getMedicalBen()));
			
			}
			
		} 
		
	    //map to list 
		list = map.values().stream().collect(Collectors.toList());

		newExchange.getMessage().setBody(new EquifaxList(list));
		
		return newExchange;
	}

}
