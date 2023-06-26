package com.CRM_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRM_project.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
