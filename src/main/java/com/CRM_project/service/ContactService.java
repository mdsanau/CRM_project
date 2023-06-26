package com.CRM_project.service;

import java.util.List;

import com.CRM_project.entities.Contact;

public interface ContactService {

	public void saveContact(Contact contact);

	public List<Contact> getAllContacts();

	public Contact getContactById(long id);

	

}
