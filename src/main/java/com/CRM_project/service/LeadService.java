package com.CRM_project.service;

import java.util.List;

import com.CRM_project.entities.Lead;


public interface LeadService {
	public void saveOneLead(Lead lead);

	public Lead findLeadById(long id);

	public void deleteById(long id);

	public List<Lead> getAllLeads();


}
