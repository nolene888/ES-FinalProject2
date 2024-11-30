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

    
    @POST
    @Path("/add") 
    @Consumes(MediaType.APPLICATION_JSON) 
    @Produces(MediaType.APPLICATION_JSON) 
    public Admin addAdmin(Admin admin) {
        
        return adminRepository.save(admin);
    }
}
