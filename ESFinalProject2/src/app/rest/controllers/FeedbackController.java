package app.rest.controllers;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import app.components.FeedbackParameter;
import app.components.FeedbackService;
import app.entity.Feedback;

@Component
@Path("/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Feedback submitFeedback(FeedbackParameter param) {
		return feedbackService.submitFeedback(param);
	}
	
	@GET
	@Path("/getFeedbackByCategory/{categoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Feedback> getFeedbackByCategory(@PathParam("categoryId") Long categoryId){
		System.out.println("Received categoryId: " + categoryId);  // Log the categoryId received from the path
	    if (categoryId == null) {
	        categoryId = 1L; 
	    }
	    return feedbackService.getFeedbackByCategory(categoryId);
	} //PROBLEM HERE: need to hard code category ID bc it returns null otherwise? 
		
}


