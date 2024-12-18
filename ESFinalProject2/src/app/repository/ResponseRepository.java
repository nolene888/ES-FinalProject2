package app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long>{
	List<Response> findByFeedbackId(Long feedbackId);
	
}
