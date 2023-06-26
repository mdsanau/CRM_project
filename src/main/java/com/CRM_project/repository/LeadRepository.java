package com.CRM_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRM_project.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
