package de.hszg.fei.ws.model;

public class Message {

	String userID;
	String appID;
	String userIDRecipient;
	String appIDRecipient;
	String message;
	String timestampe;
	
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimestampe() {
		return timestampe;
	}
	public void setTimestampe(String timestampe) {
		this.timestampe = timestampe;
	}
}
