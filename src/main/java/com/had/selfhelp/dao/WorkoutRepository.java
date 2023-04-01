package com.had.selfhelp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.had.selfhelp.entity.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

}
