package com.lzb.camel.camel;



import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.lzb.hr.beans.objectbeanlist.EmployeeBenefitsList;
import com.lzb.hr.beans.objectbeans.EmployeeBenefits;
import com.lzb.hr.beans.vendorbeanlist.EquifaxList;
import com.lzb.hr.beans.vendorbeans.Equifax;



@Component(value = "")

class EquifaxRouteBuilder extends RouteBuilder
{



    @Value("${equifaxoutboundroute.from.path}")
    String fromPath;
    
    @Value("${equifaxoutboundroute.to.path}")
    String toPath;
    
    @Value("${equifaxoutboundroute.url.equifax}")
    String equifaxUrl;
    
    @Value("${equifaxoutboundroute.bean.vendorbean.equifax}")
    String vendorBean;
    
    @Value("${equifaxoutboundroute.bean.vendorbeanlist.equifax}")
    String vendorBeanList;
    
    @Value("${equifaxoutboundroute.name}")
    String routeName;
    
    @Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
    	
	
    from("timer:scheduler?period=120000")
         .log("Scheduled job!")
    .to("direct:"+routeName);
	
    
	from("direct:"+routeName)
        .log(routeName+" started")
        .setHeader(Exchange.HTTP_METHOD).constant(HttpMethod.GET)
        .to(equifaxUrl)
        .unmarshal()
        .json(JsonLibrary.Jackson,Class.forName(vendorBeanList))
        .log("Response at 62 : ${body}")    
        .process(new MyProcessor())
        .marshal()
        .bindy(BindyType.Csv,Class.forName(vendorBean))
      
	.to(toPath);

    }

}