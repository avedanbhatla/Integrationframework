package com.lzb.hr.beans.vendorbeanlist;

import java.util.List;

import com.lzb.hr.beans.vendorbeans.Equifax;

public class EquifaxList {

	List<Equifax> benList;

	public List<Equifax> getBenList() {
		return benList;
	}

	public void setBenList(List<Equifax> benList) {
		this.benList = benList;
	}

	public EquifaxList(List<Equifax> benList) {
		super();
		this.benList = benList;
	}

	public EquifaxList() {
		super();
	}
	
	
	
}
