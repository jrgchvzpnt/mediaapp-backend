package com.mitocode.service;

import java.util.List;

import com.mitocode.model.ConsultExam;

public interface IConsultExamService {
    List<ConsultExam> getExamsByConsultId(Integer id);
}
