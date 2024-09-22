package com.mitocode.service.impl;

import java.util.List;

import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    //Cambiar segun quien lo invoque (POLIMORFISMO)
    protected abstract IGenericRepo<T, ID> getRepo();


    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) {
        getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID NOT FOUND: " + id)   );
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID NOT FOUND: " + id)   );
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID NOT FOUND: " + id)   );
        getRepo().deleteById(id);
    }

}
