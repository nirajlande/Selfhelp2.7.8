package com.had.selfhelp.controller;

import java.util.List;

import com.had.selfhelp.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.had.selfhelp.service.DoctorService;
import com.had.selfhelp.service.PatientService;
import com.had.selfhelp.service.WorkoutService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	private PatientService patientService;
	private DoctorService doctorService;
	private WorkoutService workoutService;
	
	@Autowired
	public PatientController(PatientService patientService, DoctorService doctorService,
			WorkoutService workoutService) {
		this.patientService = patientService;
		this.doctorService = doctorService;
		this.workoutService = workoutService;
	}

//	@PostMapping("/")
//	public Patient addPatient(@RequestBody Patient thePatient) {
//		thePatient.setPatient_id(0);
//		Doctor theDoctor = doctorService.assignDoctor();
//		thePatient.setDoctor(theDoctor);
//		patientService.save(thePatient);
//		workoutService.assignWorkout(thePatient);
//		return thePatient;
//	}

	@GetMapping("/user/{userId}")
	@PreAuthorize("hasAuthority('Patient')")
	public String update(@RequestBody LoginRequest h){
		return "this is Patient";
	}
	@PostMapping("/responses/{patientId}")
	public void addResponses(@RequestBody List<Questionnaire_response> response, @PathVariable(name = "patientId") int patient_id) {
		System.out.println(response);
		patientService.saveResponses(response, patient_id);
	}
	
	@GetMapping("/questions")
	public List<Questionnaire> getQuestions() {
		return patientService.getQuestions();
	}
	
	@GetMapping("/responses/{patientId}")
	public List<Questionnaire_response> getResponses(@PathVariable(name = "patientId") int patientId) {
		return patientService.getResponses(patientId);
	}
	
	@PostMapping("/login")
	public Patient login(@RequestBody Patient p) {
		return patientService.login(p);
	}
	
	@GetMapping("/workout/{patientId}")
	public List<Workout_instance> getWorkout(@PathVariable(name = "patientId") int patientId) {
		return workoutService.findWorkoutInstances(patientId);
	}
	
	@GetMapping("/workout/questions/{workout_id}")
	public List<Workout_question> getWorkoutQuestions(@PathVariable(name = "workout_id") int workout_id) {
		return workoutService.findWorkoutQuestions(workout_id);
	}
	
	@PostMapping("/workout/response")
	public List<Workout_question_response> saveWorkoutResponse(@RequestBody List<Workout_question_response> responseList) {
		return workoutService.saveResponse(responseList);
	}
}
