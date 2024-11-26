package app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long>{

	
}
