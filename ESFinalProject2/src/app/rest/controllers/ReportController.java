package app.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.components.ReportService;


@Component
@Path("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object generateFeedbackReport() {
        return reportService.generateFeedbackReport();
    }
}
