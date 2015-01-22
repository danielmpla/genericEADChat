package de.hszg.fei.ws.model;

import de.hszg.fei.ws.model.repository.UserEntity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso(UserEntity.class)
@XmlRootElement
public class UserWithRecipient {

    private User user;
    private User recipient;

    public UserWithRecipient() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}
