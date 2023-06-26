package com.CRM_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.CRM_project.entities.Contact;
import com.CRM_project.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	//localhost:9090/zoho_crm/listallcontact
		@RequestMapping("/listallcontact")
		public String listAllContacts(Model model) {
			List<Contact> contacts = contactService.getAllContacts();
			model.addAttribute("contacts", contacts);
			return "list_contacts";
		}
}
