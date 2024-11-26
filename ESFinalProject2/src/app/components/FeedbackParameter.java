package app.components;

public class FeedbackParameter {
	private String content;
	private Long categoryId;
	private Long userId;
	
	public FeedbackParameter() {
		
	}

	public FeedbackParameter(String content, Long categoryId, Long userId) {
		super();
		this.content = content;
		this.categoryId = categoryId;
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "FeedbackParameter [content=" + content + ", categoryId=" + categoryId + ", userId=" + userId + "]";
	}
	
	

}
