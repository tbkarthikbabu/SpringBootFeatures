package dev.boot.features.jms.messaging;

public class User {

	private String emailId;
	private boolean isActive;

	public User() {
	}

	public User(String emailId, boolean isActive) {
		this.emailId = emailId;
		this.isActive = isActive;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", isActive=" + isActive + "]";
	}

}
