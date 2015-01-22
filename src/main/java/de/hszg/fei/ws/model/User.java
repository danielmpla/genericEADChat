package de.hszg.fei.ws.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Daniel on 22.01.2015.
 */
@XmlRootElement
public class User {
    private Long userId;
    private Long appId;
    private String username;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
