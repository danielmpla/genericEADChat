package de.hszg.fei.ws.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "user")
@XmlRootElement
public class User {

    @Id
    @XmlTransient
    private Long id;
    private String userID;
    private String appID;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (appID != null ? !appID.equals(user.appID) : user.appID != null) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (userID != null ? !userID.equals(user.userID) : user.userID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        result = 31 * result + (appID != null ? appID.hashCode() : 0);
        return result;
    }
}
