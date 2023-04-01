package com.had.selfhelp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.had.selfhelp.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	Patient findByUsernameAndPassword(String username, String password);
}
