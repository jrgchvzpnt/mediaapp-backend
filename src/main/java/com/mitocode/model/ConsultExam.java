package com.mitocode.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@IdClass(ConsultExamPK.class)

public class ConsultExam {

    //llave primaria compuesta
    @Id
    private Consult consult;

    @Id
    private Exam exam;
}
