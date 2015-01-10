package de.hszg.fei.ws.model;

public class UserWithRecipient {

	String userID;
	String appID;
	String userIDRecipient;
	String appIDRecipient;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getAppID() {
		return appID;
	}
	public void setAppID(String appID) {
		this.appID = appID;
	}
	public String getUserIDRecipient() {
		return userIDRecipient;
	}
	public void setUserIDRecipient(String userIDRecipient) {
		this.userIDRecipient = userIDRecipient;
	}
	public String getAppIDRecipient() {
		return appIDRecipient;
	}
	public void setAppIDRecipient(String appIDRecipient) {
		this.appIDRecipient = appIDRecipient;
	}
}
