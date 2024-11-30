package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.components.FeedbackParameter;
import app.components.FeedbackService;
import app.components.ResponseDTO;
import app.entity.Feedback;
import app.entity.Response;
import app.repository.AdminRepository;
import app.repository.FeedbackRepository;
import app.repository.ResponseRepository;

import java.time.LocalDateTime;

@Component
@Path("/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private AdminRepository adminRepository;
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Feedback submitFeedback(FeedbackParameter param) {
		return feedbackService.submitFeedback(param);
	}
	

	@GET
    @Path("/getFeedbackByCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Feedback> getFeedbackByCategory(@QueryParam("categoryId") Long categoryId) {
        System.out.println("Received categoryId: " + categoryId);  
        return feedbackService.getFeedbackByCategory(categoryId);
    }
	
	@POST
	@Path("/{id}/response")  
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response respondToFeedback(@PathParam("id") Long feedbackId, ResponseDTO responseDTO) {
	    
	    Feedback feedback = feedbackRepository.findById(feedbackId).orElse(null);
	    if (feedback == null) {
	        throw new RuntimeException("Feedback not found");
	    }

	    
	    Long adminId = responseDTO.getAdminId();
	    String responseText = responseDTO.getResponseText();

	    
	    Response response = new Response(feedbackId, responseText, LocalDateTime.now(), adminId);
	    return responseRepository.save(response);  
	}
	
	@GET
	@Path("/{id}/responses")
	@Produces(MediaType.TEXT_PLAIN)
	public String getResponsesForFeedback(@PathParam("id") Long feedbackId) {
		
		return feedbackService.getFeedbackResponse(feedbackId);
	}
	
	@GET
    @Path("/allfeedback")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }
		
}


