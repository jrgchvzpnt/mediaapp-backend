package com.mitocode.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Patient;
import com.mitocode.service.IPatientService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor


public class PatientController {

    
     private final IPatientService service;

    @GetMapping
    public List<Patient> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient) {
        return service.save(patient);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable("id") Integer id, @RequestBody Patient patient){
        patient.setIdPatient(id);
        return service.update(id, patient);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.delete(id);
    }
    
    

   
   
   
   
    



    /*@GetMapping
    public Patient save(){
        Patient patient = new Patient();
        patient.setIdPatient(0);
        patient.setFirstName("Mito");
        return service.save(patient);
    }*/
     
}
