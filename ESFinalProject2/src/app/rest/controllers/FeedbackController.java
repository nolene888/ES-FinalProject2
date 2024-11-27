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
        System.out.println("Received categoryId: " + categoryId);  // Log the categoryId received
        return feedbackService.getFeedbackByCategory(categoryId);
    }
	
	@POST
	@Path("/{id}/response")  // Define the URL path, including the feedback ID
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response respondToFeedback(@PathParam("id") Long feedbackId, ResponseDTO responseDTO) {
	    // Check if the feedback exists
	    Feedback feedback = feedbackRepository.findById(feedbackId).orElse(null);
	    if (feedback == null) {
	        throw new RuntimeException("Feedback not found");
	    }

	    // Extract admin ID and response text from the DTO
	    Long adminId = responseDTO.getAdminId();
	    String responseText = responseDTO.getResponseText();

	    // Create and save the response
	    Response response = new Response(feedbackId, responseText, LocalDateTime.now(), adminId);
	    return responseRepository.save(response);  // Save and return the response
	}

		
}


