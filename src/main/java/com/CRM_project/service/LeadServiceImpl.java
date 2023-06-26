package com.CRM_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRM_project.entities.Lead;
import com.CRM_project.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService{
	@Autowired
	private LeadRepository leadRepository;

	@Override
	public void saveOneLead(Lead lead) {
		leadRepository.save(lead);
		
		
	}

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadRepository.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteById(long id) {

		leadRepository.deleteById(id);
	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepository.findAll();
		return leads;
	}
	
	

}
