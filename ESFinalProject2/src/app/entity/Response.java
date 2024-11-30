package app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name="response_table")
public class Response {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	@NotNull
	private Long feedbackId;
	
	@Column
	@NotNull
	private String response;
	
	@Column
	@NotNull
	private LocalDateTime timestamp;
	
	@Column
	@NotNull
	private Long adminId;
	
	
	
	public Response() {
		
	}

	public Response(@NotNull Long feedbackId, @NotNull String response, @NotNull LocalDateTime timestamp,
			@NotNull Long adminId) {
		super();
		this.feedbackId = feedbackId;
		this.response = response;
		this.timestamp = timestamp;
		this.adminId = adminId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Response [id=" + id + ", feedbackId=" + feedbackId + ", response=" + response + ", timestamp="
				+ timestamp + ", adminId=" + adminId + "]";
	}

	
	
}
