package app.components;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Feedback;
import app.entity.Response;
import app.repository.FeedbackRepository;
import app.repository.ResponseRepository;

@Component
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private ResponseRepository responseRepository;
	
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
	
	public String getFeedbackResponse(Long feedbackId) {
		
		Feedback feedback = feedbackRepository.findById(feedbackId).orElse(null);
		if (feedback == null) {
			throw new RuntimeException("Feedback not found.");
		}
		
		StringBuilder responseBuilder = new StringBuilder();
		
		responseBuilder.append("Feedback Details:\n");
	    responseBuilder.append("-----------------\n");
	    responseBuilder.append("Feedback ID: ").append(feedback.getId()).append("\n");
	    responseBuilder.append("Feedback Text: ").append(feedback.getContent()).append("\n");
	    responseBuilder.append("Category: ").append(feedback.getCategoryId()).append("\n\n");
	     
	    responseBuilder.append("Responses:\n");
        responseBuilder.append("----------\n");
        
        List<Response> responses = responseRepository.findByFeedbackId(feedbackId);
        if (responses.isEmpty()) {
            responseBuilder.append("No responses yet.\n");
        } else {
            for (Response response : responses) {
                responseBuilder.append("Response ID: ").append(response.getId()).append("\n");
                responseBuilder.append("Response Text: ").append(response.getResponse()).append("\n");
                responseBuilder.append("Admin ID: ").append(response.getAdminId()).append("\n");
                responseBuilder.append("Response Date: ").append(response.getTimestamp()).append("\n\n");
            }
        }

        return responseBuilder.toString();
	}

} 




