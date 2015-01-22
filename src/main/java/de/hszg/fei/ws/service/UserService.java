package de.hszg.fei.ws.service;

import de.hszg.fei.ws.model.User;
import de.hszg.fei.ws.model.UserList;
import de.hszg.fei.ws.model.repository.UserEntity;

/**
 * Created by daniel on 17.01.15.
 */
public interface UserService {
    public boolean userIsSaved(User user);

    public UserEntity save(User user);

    public UserEntity find(User user);
}
