package com.CRM_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRM_project.entities.Billing;
import com.CRM_project.repository.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {
	
	@Autowired
	private BillingRepository billingRepository;

	@Override
	public void saveBills(Billing bill) {

		billingRepository.save(bill);
		
	}

		
	

}
