package app.rest.controllers;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import app.entity.Admin;
import app.repository.AdminRepository;

@Component
@Path("/admin")
public class AdminController 
{
	@Autowired
    private AdminRepository adminRepository;

    // POST method to add a new admin
    @POST
    @Path("/add") // Define the path for this POST request
    @Consumes(MediaType.APPLICATION_JSON) // Define that this method consumes JSON
    @Produces(MediaType.APPLICATION_JSON) // Define that this method produces JSON
    public Admin addAdmin(Admin admin) {
        // Save the admin entity to the database
        return adminRepository.save(admin);
    }
}
