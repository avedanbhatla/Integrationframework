package com.lzb.camel.camel;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;

import org.apache.camel.Processor;




public class MyProcessor implements Processor {
	
	

	@Override
	public void process(Exchange exchange) throws Exception {
		
		System.out.println("in process");
	
		com.lzb.hr.beans.vendorbeanlist.EquifaxList emp =  (com.lzb.hr.beans.vendorbeanlist.EquifaxList)exchange.getIn().getBody();
		
		List<com.lzb.hr.beans.vendorbeans.Equifax> empList = new ArrayList<com.lzb.hr.beans.vendorbeans.Equifax>();
		
		for(com.lzb.hr.beans.vendorbeans.Equifax e: emp.getBenList()){
			empList.add(e);
		}
		
		exchange.getIn().setBody(empList);
		
				
		/*
		 * Without Bindy. String level manipulation
		 * 
		*/
		/*
		StringBuilder csv = new StringBuilder();
		for(int i = 0 ; i < emp.getEmployeesList().size(); i++)
		{
		csv.append(emp.getEmployeesList().get(i).getFirstName());
		csv.append(",");
		csv.append(emp.getEmployeesList().get(i).getLastName());
		csv.append("\n");
		}
		exchange.getIn().setBody(csv.toString());
		
		
*/	
		
		
	}
	
	
	 

}
