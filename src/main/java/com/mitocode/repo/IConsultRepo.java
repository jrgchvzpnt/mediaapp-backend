package com.mitocode.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Consult;

public interface IConsultRepo extends IGenericRepo<Consult, Integer> {
    // Codigo JPQL Java Pesistence Query Language
    @Query("FROM Consult c WHERE c.patient.dni = :dni OR LOWER(c.patient.firstName) LIKE %:fullname% OR LOWER(c.patient.lastName) LIKE %:fullname%")
    List<Consult> search(@Param("dni") String dni, @Param("fullname") String fullname);

    @Query("FROM Consult c WHERE c.consultDate BETWEEN :date1 AND :date2")
    List<Consult> searchByDates(@Param("date1") LocalDateTime date1, @Param("date2") LocalDateTime date2);

}
