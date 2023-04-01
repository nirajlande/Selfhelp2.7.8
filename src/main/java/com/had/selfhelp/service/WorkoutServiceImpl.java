package com.had.selfhelp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.had.selfhelp.dao.PatientRepository;
import com.had.selfhelp.dao.WorkoutRepository;
import com.had.selfhelp.dao.Workout_instance_repo;
import com.had.selfhelp.dao.Workout_question_response_repo;
import com.had.selfhelp.entity.Patient;
import com.had.selfhelp.entity.Workout;
import com.had.selfhelp.entity.Workout_instance;
import com.had.selfhelp.entity.Workout_question;
import com.had.selfhelp.entity.Workout_question_response;

@Service
public class WorkoutServiceImpl implements WorkoutService {

	private WorkoutRepository workoutRepository;
	private Workout_instance_repo workout_instance_repo;
	private PatientRepository patientRepository;
	private Workout_question_response_repo response_repo;
	
	@Autowired
	public WorkoutServiceImpl(WorkoutRepository workoutRepository, Workout_instance_repo workout_instance_repo,
			PatientRepository patientRepository, Workout_question_response_repo response_repo) {
		this.workoutRepository = workoutRepository;
		this.workout_instance_repo = workout_instance_repo;
		this.patientRepository = patientRepository;
		this.response_repo = response_repo;
	}

	@Override
	public void save(Workout theWorkout) {
		workoutRepository.save(theWorkout);
	}

	@Override
	public List<Workout_instance> assignWorkout(Patient thePatient) {
		
		Workout_instance w1 = new Workout_instance();
		Workout_instance w2 = new Workout_instance();
		Workout_instance w3 = new Workout_instance();
		
		w1.setPatient(thePatient);
		w1.setWorkout(workoutRepository.getReferenceById(1));
		w1.setCompleted(false);
		
		w2.setPatient(thePatient);
		w2.setWorkout(workoutRepository.getReferenceById(2));
		w2.setCompleted(false);
		
		w3.setPatient(thePatient);
		w3.setWorkout(workoutRepository.getReferenceById(3));
		w3.setCompleted(false);
		
		List<Workout_instance> list = new ArrayList<Workout_instance>();
		list.add(w1);
		list.add(w2);
		list.add(w3);
		
		workout_instance_repo.saveAll(list);
		
		return list;
	}

	@Override
	public List<Workout_instance> findWorkoutInstances(int patientId) {
		return workout_instance_repo.findByPatient(patientRepository.getReferenceById(patientId));
	}

	@Override
	public List<Workout_instance> addWorkoutInstances(List<Workout> list, int patientId) {
		List<Workout_instance> temp = new ArrayList<Workout_instance>();
		System.out.println("In service");
		for(Workout workout:list) {
			System.out.println("Workout: "+workout);
			Workout_instance instance = new Workout_instance();
			instance.setCompleted(false);
			instance.setPatient(patientRepository.getReferenceById(patientId));
			instance.setWorkout(workout);
			workout_instance_repo.save(instance);
			temp.add(instance);
		}
		System.out.println("Added successfully!!!");
		return temp;
	}

	@Override
	public List<Workout> findWorkoutNotAssigned(int patientId) {
		List<Workout_instance> list = findWorkoutInstances(patientId);
		List<Workout> assigned_workouts = new ArrayList<Workout>();
		for(Workout_instance instance:list) {
			assigned_workouts.add(instance.getWorkout());
		}
		List<Workout> workouts = workoutRepository.findAll();
		workouts.removeAll(assigned_workouts);
		return workouts;
	}

	@Override
	public List<Workout> findWorkout() {
		return workoutRepository.findAll();
	}

	@Override
	public List<Workout_question> findWorkoutQuestions(int workout_id) {
		return workoutRepository.getReferenceById(workout_id).getQuestions();
	}

	@Override
	public List<Workout_question_response> saveResponse(List<Workout_question_response> responseList) {
		Workout_instance instance = workout_instance_repo.getReferenceById(responseList.get(0).getWorkout_instance().getWorkout_instance_id());
		instance.setCompleted(true);
		workout_instance_repo.save(instance);
		return response_repo.saveAll(responseList);
	}

}
