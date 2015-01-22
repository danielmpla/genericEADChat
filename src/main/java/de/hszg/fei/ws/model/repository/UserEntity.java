package de.hszg.fei.ws.model.repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"user_id", "app_id"})
)
public class UserEntity {

    @Id
    private Long id;
    @Column(name = "user_id")
    private Long userID;
    @ManyToOne
    private ApplicationEntity application;
    private String username;
    @OneToMany(cascade = {CascadeType.REFRESH})
    @Column(name = "chat_able_user")
    private List<UserEntity> chatAbleUser;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public ApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(ApplicationEntity applicationEntity) {
        this.application = applicationEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserEntity> getChatAbleUser() {
        return chatAbleUser;
    }

    public void setChatAbleUser(List<UserEntity> chatAbleUser) {
        this.chatAbleUser = chatAbleUser;
    }

    public void addChatAbleUser(UserEntity user) {
        this.chatAbleUser.add(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity user = (UserEntity) o;

        if (application != null ? !application.equals(user.application) : user.application != null) return false;
        if (chatAbleUser != null ? !chatAbleUser.equals(user.chatAbleUser) : user.chatAbleUser != null) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (userID != null ? !userID.equals(user.userID) : user.userID != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        result = 31 * result + (application != null ? application.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (chatAbleUser != null ? chatAbleUser.hashCode() : 0);
        return result;
    }
}
