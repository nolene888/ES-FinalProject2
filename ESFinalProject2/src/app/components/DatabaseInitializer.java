package app.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Admin;
import app.entity.Category;
import app.entity.User;
import app.repository.AdminRepository;
import app.repository.CategoryRepository;
import app.repository.UserRepository;

@Component
public class DatabaseInitializer {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void init() {
		
		if(categoryRepository.count() == 0) 
		{
			categoryRepository.save(new Category("facilities"));
			categoryRepository.save(new Category("academics"));
			categoryRepository.save(new Category("family"));
			categoryRepository.save(new Category("mental health"));
			categoryRepository.save(new Category("finances"));

		}
		
		if(adminRepository.count()==0) 
		{
			adminRepository.save(new Admin("John Doe", "john.doe@example.com", "superadmin"));
			adminRepository.save(new Admin("Jane Smith", "jane.smith@example.com", "moderator"));

		}
		
		if(userRepository.count()==0) 
		{
			userRepository.save(new User("nolene.ignacio@student.ateneo.edu", "student"));
			userRepository.save(new User("random@gmail.com", "faculty"));

		}

	}
}
