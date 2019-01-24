package com.sdorilas.tracer.tracerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdorilas.tracer.tracerapp.dto.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>{

}
