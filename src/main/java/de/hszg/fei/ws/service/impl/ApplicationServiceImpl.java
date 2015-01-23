package de.hszg.fei.ws.service.impl;

import de.hszg.fei.ws.model.Message;
import de.hszg.fei.ws.model.User;
import de.hszg.fei.ws.model.UserList;
import de.hszg.fei.ws.model.repository.ApplicationEntity;
import de.hszg.fei.ws.model.repository.UserEntity;
import de.hszg.fei.ws.repository.UserRepository;
import de.hszg.fei.ws.service.ApplicationService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Daniel on 22.01.2015.
 */
@Dependent
public class ApplicationServiceImpl implements ApplicationService, Serializable {
    @Inject
    private UserRepository userRepository;


    @Override
    public UserList findAllChatAbleUsers(User user) {
        List<UserEntity> allUsers = this.userRepository.findAll();

        for (UserEntity user1 : allUsers) {
            if (user.getUsername().equals(user1.getUsername()) && user.getUserId().equals(user1.getUserID())) {
                allUsers.remove(user1);
                break;
            }
        }

        UserList userList = new UserList();

        for (UserEntity userEntity : allUsers) {
            User user1 = new User();

            user1.setUserId(userEntity.getUserID());
            user1.setAppId(userEntity.getApplication().getId());
            user1.setUsername(userEntity.getUsername());

            userList.addUser(user1);
        }

        userList.setNumUsers(userList.getUserList().size());

        return userList;
    }

    @Override
    public void notifyServer(Message message) {
        try {
            throw new NoSuchMethodException("Method is not used in demo");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerServer(ApplicationEntity applicationEntity) {
        try {
            throw new NoSuchMethodException("Method is not used in demo");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
