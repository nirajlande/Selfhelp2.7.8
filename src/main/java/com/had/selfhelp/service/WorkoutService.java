package com.had.selfhelp.service;

import java.util.List;

import com.had.selfhelp.entity.Patient;
import com.had.selfhelp.entity.Workout;
import com.had.selfhelp.entity.Workout_instance;
import com.had.selfhelp.entity.Workout_question;
import com.had.selfhelp.entity.Workout_question_response;

public interface WorkoutService {

	public void save(Workout theWorkout);
	
	public List<Workout_instance> assignWorkout(Patient thePatient);
	
	public List<Workout_instance> findWorkoutInstances(int patientId);
	
	public List<Workout_instance> addWorkoutInstances(List<Workout> list, int patientId);
	
	public List<Workout> findWorkoutNotAssigned(int patientId);
	
	public List<Workout> findWorkout();

	public List<Workout_question> findWorkoutQuestions(int workout_id);

	public List<Workout_question_response> saveResponse(List<Workout_question_response> responseList);
		
}
