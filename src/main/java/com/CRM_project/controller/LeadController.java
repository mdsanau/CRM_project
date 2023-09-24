package com.CRM_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CRM_project.entities.Contact;
import com.CRM_project.entities.Lead;
import com.CRM_project.service.ContactService;
import com.CRM_project.service.LeadService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;

	@Autowired
	private ContactService contactService;

	@GetMapping("/viewCreateLeadPage")
	public String viewCreateLeadPage() {
		return "create_new_page";
	}

	@PostMapping("/save")
	public String saveLead(@ModelAttribute("lead") Lead lead, Model model) {
		
		leadService.saveOneLead(lead);
		
		
		model.addAttribute("lead", lead);
		
		

		return "lead_info";
	}

	@PostMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.findLeadById(id);
		Contact contact = new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		contactService.saveContact(contact);

		leadService.deleteById(id);

		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
	}

	// localhost:9090/zoho_crm/listall

	@RequestMapping("/listall")
	public String listAllLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}

	@RequestMapping("/leadinfo")
	public String leadinfo(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}


	}


