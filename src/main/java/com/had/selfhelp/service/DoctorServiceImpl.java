package com.had.selfhelp.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.had.selfhelp.dao.DoctorRepository;
import com.had.selfhelp.entity.Doctor;
import com.had.selfhelp.entity.Patient;

class sortByPatient implements Comparator<Doctor>{

	@Override
	public int compare(Doctor d1, Doctor d2) {
		return d1.getPatients().size()-d2.getPatients().size();
	}	
};

@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorRepository doctorRepository;
	
	@Autowired
	public DoctorServiceImpl(DoctorRepository theDoctorRepository) {
		doctorRepository = theDoctorRepository;
	}
	
	@Override
	public void save(Doctor theDoctor) {
		doctorRepository.save(theDoctor);
	}

	@Override
	public Doctor findById(int theId) {
		return doctorRepository.getReferenceById(theId);
	}

	@Override
	public List<Patient> findPatients(int theId) {
		Doctor theDoctor = doctorRepository.getReferenceById(theId);
		return theDoctor.getPatients();
	}

	@Override
	public Doctor login(Doctor D) {
		Doctor theDoctor = doctorRepository.findByUsernameAndPassword(D.getUsername(),D.getPassword());
		if(theDoctor==null)
			throw new RuntimeException("Did not find doctor with these credentials");
		return theDoctor;
	}

	@Override
	public Doctor assignDoctor() {
		List<Doctor> doctorList = doctorRepository.findAll();
		doctorList.remove(doctorRepository.findByType('C'));
		doctorList.remove(doctorRepository.findByType('A'));
		doctorList.sort(new sortByPatient());
		return doctorList.get(0);
	}

}
