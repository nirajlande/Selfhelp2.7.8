package com.had.selfhelp.service;

import com.had.selfhelp.dao.PatientRepository;
import com.had.selfhelp.dao.RoleRepository;
import com.had.selfhelp.entity.Doctor;
import com.had.selfhelp.entity.Patient;
import com.had.selfhelp.entity.Role;
//import com.had.selfhelp.exception.ResourceNotFoundException;
import com.had.selfhelp.dao.UserRepository;
import com.had.selfhelp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    RoleRepository roleRepository;
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> findByUserId(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ExpressionException(String.format("User Id : %d is not found", userId)));
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity<User> createUser(Patient patient) {

        User user = new User();
        user.setUsername(patient.getUsername());
        user.setPassword(patient.getPassword());
        String encPwd = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encPwd);
        Role role = roleRepository.findByName("Patient");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRoleSet(userRoles);
        return ResponseEntity.ok(userRepository.save(user));
    }

    public ResponseEntity<User> createDoctor(Doctor doctor) {

        User user = new User();
        user.setUsername(doctor.getUsername());
        user.setPassword(doctor.getPassword());
        String encPwd = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encPwd);
        Role role = roleRepository.findByName("Doctor");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRoleSet(userRoles);
        return ResponseEntity.ok(userRepository.save(user));
    }
//    public ResponseEntity<User> updateUser(User userData, int userId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(()-> new ResourceNotFoundException(String.format("User Id : %d is not found", userId)));
//        user.setUserId(userId);
//        return ResponseEntity.ok(userRepository.save(user));
//    }
//
//    public ResponseEntity<String> deleteUserById(int userId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(()-> new ResourceNotFoundException(String.format("User Id : %d is not found", userId)));
//        userRepository.deleteById(user.getUserId());
//        return ResponseEntity.ok().body("User id: "+userId+" is deleted.");
//    }
}
