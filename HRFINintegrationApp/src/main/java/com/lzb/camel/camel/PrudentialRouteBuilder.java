package com.lzb.camel.camel;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component(value = "")

class PrudentialRouteBuilder extends RouteBuilder
{



    @Value("${prudentialoutboundroute.from.path}")
    String fromPath;
    
    @Value("${prudentialoutboundroute.to.path}")
    String toPath;
    
    @Value("${prudentialoutboundroute.url.prudential}")
    String equifaxUrl;
    
    @Value("${prudentialoutboundroute.bean.vendorbean.prudential}")
    String vendorBean;
    
    @Value("${prudentialoutboundroute.bean.vendorbeanlist.prudential}")
    String vendorBeanList;
    
    @Value("${prudentialoutboundroute.name}")
    String routeName;
    
    @Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
    	
	
    from("timer:scheduler?period=130000")
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
       // .log("Response : ${body}")
	.to(toPath);

    }

}
