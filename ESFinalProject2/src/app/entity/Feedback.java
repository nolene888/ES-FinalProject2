package app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="feedback_table")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	@NotNull
	private Long userId;
	
	@Column
	@NotNull
	private String content;
	
	@Column
	@NotNull
	private LocalDateTime timestamp;
	
	@Column
	@NotNull
	private Long categoryId;

	public Feedback() {
		
	}

	public Feedback(@NotNull Long userId, @NotNull String content, @NotNull LocalDateTime timestamp,
			@NotNull Long categoryId) {
		super();
		this.userId = userId;
		this.content = content;
		this.timestamp = timestamp;
		this.categoryId = categoryId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", userId=" + userId + ", content=" + content + ", timestamp=" + timestamp
				+ ", categoryId=" + categoryId + "]";
	}

	

}
