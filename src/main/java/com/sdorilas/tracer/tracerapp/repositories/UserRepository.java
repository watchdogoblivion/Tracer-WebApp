package com.sdorilas.tracer.tracerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdorilas.tracer.tracerapp.dto.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
