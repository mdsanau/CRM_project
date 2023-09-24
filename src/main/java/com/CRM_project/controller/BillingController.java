package com.CRM_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CRM_project.entities.Billing;
import com.CRM_project.entities.Contact;
import com.CRM_project.service.BillingService;
import com.CRM_project.service.ContactService;

@Controller
public class BillingController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private BillingService billingService;
	
	@RequestMapping("/generateBill")
	public String viewBillingPage(@RequestParam("id") long id, Model model) {
		
		Contact contact= contactService.getContactById(id);
		
		model.addAttribute("contact", contact);
		
		return "generate_bill";
	}
	
	@RequestMapping("/saveBill")
	public String saveBill(@ModelAttribute Billing bill, Model model) {
		
		billingService.saveBills(bill);
		
		model.addAttribute("bill",bill);
		
		return "generate_bill";
		
	}
}
