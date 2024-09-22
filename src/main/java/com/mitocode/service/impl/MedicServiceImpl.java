package com.mitocode.service.impl;



import org.springframework.stereotype.Service;
import com.mitocode.model.Medic;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.ImedicRepo;
import com.mitocode.service.IMedicService;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class MedicServiceImpl extends CRUDImpl<Medic,Integer> implements IMedicService {
   
    private final ImedicRepo repo;// = new PatientRepo();

    @Override
    protected IGenericRepo<Medic, Integer> getRepo() {
        return repo;
    }

   
   
}
