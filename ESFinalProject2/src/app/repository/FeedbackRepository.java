package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

	List<Feedback> findByCategoryId(Long categoryId);

}
