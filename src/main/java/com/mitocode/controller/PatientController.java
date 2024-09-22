package com.mitocode.controller;

import java.net.URI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.dto.PatientDTO;
import com.mitocode.model.Patient;
import com.mitocode.service.IPatientService;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("${patient.controller.path}")
@RequiredArgsConstructor


public class PatientController {

    
     private final IPatientService service;
     private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> findAll(){
        List<PatientDTO> list = service.findAll().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable("id") Integer id){
        Patient obj = service.findById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PatientDTO dto){
        Patient obj = service.save(convertToEntity(dto));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPatient()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable("id") Integer id, @RequestBody PatientDTO dto){
        dto.setIdPatient(id);
        Patient obj = service.update(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDto(obj));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        service.delete(id);

        return ResponseEntity.noContent().build(); //204 NO CONTENT
    }
    

    private PatientDTO convertToDto(Patient obj){
        return modelMapper.map(obj, PatientDTO.class);
    }

    private Patient convertToEntity(PatientDTO dto){
        return modelMapper.map(dto, Patient.class);
    }
    
     
}
