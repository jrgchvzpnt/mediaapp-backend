package com.mitocode.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mitocode.model.ConsultExam;
import com.mitocode.repo.IConsultExamRepo;
import com.mitocode.service.IConsultExamService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultExamServiceImpl implements IConsultExamService {

    private final IConsultExamRepo repo;

    @Override
    public List<ConsultExam> getExamsByConsultId(Integer id) {
        return repo.getExamsByConsultId(id);
    }

}
