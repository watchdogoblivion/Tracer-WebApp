package com.sdorilas.tracer.tracerapp.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sdorilas.tracer.tracerapp.dto.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

	@Query(value ="SELECT * FROM questions WHERE date_time <= ?1", 
			  nativeQuery = true)
    List<Question> findRecent(LocalDateTime ldt);
	
	Question findByDateTime(LocalDateTime ldt);
	
	@Query(value="SELECT * FROM questions ORDER BY date_time DESC LIMIT 10",
			nativeQuery = true)
	List<Question> findLastTen();
}
