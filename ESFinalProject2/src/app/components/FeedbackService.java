package app.components;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Feedback;
import app.repository.FeedbackRepository;

@Component
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	public Feedback submitFeedback(FeedbackParameter param) {
		 Feedback feedback = new Feedback();
	     feedback.setContent(param.getContent());
	     feedback.setCategoryId(param.getCategoryId());
	     feedback.setUserId(param.getUserId());
	     feedback.setTimestamp(LocalDateTime.now());

	     
	     return feedbackRepository.save(feedback);

	}
	
	public List<Feedback> getFeedbackByCategory(Long categoryId){
		
		System.out.println("Querying for categoryId: " + categoryId);
	    List<Feedback> feedbackList = feedbackRepository.findByCategoryId(categoryId);
	    System.out.println("Found feedback for category " + categoryId + ": " + feedbackList);
	    return feedbackList;
//		return feedbackRepository.findByCategoryId(categoryId); 
	}

}
