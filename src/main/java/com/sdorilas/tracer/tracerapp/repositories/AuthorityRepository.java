package com.sdorilas.tracer.tracerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdorilas.tracer.tracerapp.dto.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}
