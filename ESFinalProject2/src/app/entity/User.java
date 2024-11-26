package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name="user_table")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private String email;
	
	@Column
    @Pattern(regexp = "student|faculty|admin|staff")
	@NotNull
	private String role;
	
	public User()
	{
		
	}
	
	

	public User(String email, @Pattern(regexp = "student|faculty|admin|staff") @NotNull String role) {
		super();
		this.email = email;
		this.role = role;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", role=" + role + "]";
	}
	
	
	
	

}
