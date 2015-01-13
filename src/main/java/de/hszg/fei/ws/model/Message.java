package de.hszg.fei.ws.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {

    @Id
    private Long id;
    private String userID;
    private String appID;
    private String userIDRecipient;
    private String appIDRecipient;
    private String message;
    private String timestampe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
