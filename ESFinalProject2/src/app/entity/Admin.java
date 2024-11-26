package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="admin_table")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	@NotNull
	private String name;
	
	@Column
	@NotNull
	private String email;
	
	@Column
	@NotNull
	private String role;

	public Admin() {
		
	}

	public Admin(@NotNull String name, @NotNull String email, @NotNull String role) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + "]";
	}
	
	
	
}
