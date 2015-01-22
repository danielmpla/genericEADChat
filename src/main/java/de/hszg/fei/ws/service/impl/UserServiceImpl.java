package de.hszg.fei.ws.service.impl;

import de.hszg.fei.ws.model.User;
import de.hszg.fei.ws.model.UserList;
import de.hszg.fei.ws.model.repository.ApplicationEntity;
import de.hszg.fei.ws.model.repository.UserEntity;
import de.hszg.fei.ws.repository.ApplicationRepository;
import de.hszg.fei.ws.repository.UserRepository;
import de.hszg.fei.ws.service.UserService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 17.01.15.
 */
@Dependent
public class UserServiceImpl implements UserService, Serializable {
    @Inject
    private UserRepository repository;
    @Inject
    private ApplicationRepository applicationRepository;

    @Override
    public boolean userIsSaved(User user) {
        return this.repository.userIsSaved(user.getUserId(), user.getAppId());
    }

    @Override
    public UserEntity save(User user) {
        ApplicationEntity applicationEntity = this.applicationRepository.find(user.getAppId());

        UserEntity userEntity = new UserEntity();

        userEntity.setUserID(user.getUserId());
        userEntity.setUsername(user.getUsername());
        userEntity.setApplication(applicationEntity);

        return this.repository.save(userEntity);
    }

    @Override
    public UserEntity find(User user) {
        return this.repository.find(user.getUserId(), user.getAppId());
    }

    @Override
    public void saveChatAbleUser(UserEntity userEntity, UserList userListObject) {
        List<UserEntity> userEntityList = new ArrayList<>();

        for (User user : userListObject.getUserList()) {
            UserEntity userEntity1 = this.find(user);
            userEntityList.add(userEntity1);
        }

        userEntity.setChatAbleUser(userEntityList);

        this.repository.save(userEntity);
    }
}
