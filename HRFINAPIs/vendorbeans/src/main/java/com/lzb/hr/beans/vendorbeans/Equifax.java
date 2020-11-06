package com.lzb.hr.beans.vendorbeans;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",")
public class Equifax {
	@DataField(pos = 1)
	String empNum;
	@DataField(pos = 2)
	String firstName;
	@DataField(pos = 3)
	String lastName;
	@DataField(pos = 4)
	String dental;
	@DataField(pos = 5)
	String medical;
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDental() {
		return dental;
	}
	public void setDental(String dental) {
		this.dental = dental;
	}
	public String getMedical() {
		return medical;
	}
	public void setMedical(String medical) {
		this.medical = medical;
	}
	public Equifax(String empNum, String firstName, String lastName, String dental, String medical) {
		super();
		this.empNum = empNum;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dental = dental;
		this.medical = medical;
	}
	
	
	public Equifax() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeeBenefits [empNum=" + empNum + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dental=" + dental + ", medical=" + medical + "]";
	}
	
	
}
