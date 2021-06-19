package com.cafe2team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe2team.dao.SalesMapper;

@Service
public class SalesService {

	@Autowired
	private SalesMapper salesMapper;
	
	public String getSalesList() {
		
		return null;
		
	}
}
