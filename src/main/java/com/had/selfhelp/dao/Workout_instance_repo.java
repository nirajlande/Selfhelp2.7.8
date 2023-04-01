package com.had.selfhelp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.had.selfhelp.entity.Patient;
import com.had.selfhelp.entity.Workout_instance;

public interface Workout_instance_repo extends JpaRepository<Workout_instance, Integer> {

	List<Workout_instance> findByPatient(Patient P);
	
}
