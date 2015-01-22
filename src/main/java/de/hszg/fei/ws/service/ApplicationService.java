package de.hszg.fei.ws.service;

import de.hszg.fei.ws.model.Message;
import de.hszg.fei.ws.model.User;
import de.hszg.fei.ws.model.UserList;
import de.hszg.fei.ws.model.repository.ApplicationEntity;

/**
 * Created by Daniel on 22.01.2015.
 */
public interface ApplicationService {
    public UserList findAllChatAbleUsers(User user);

    public void notifyServer(Message message);

    public void registerServer(ApplicationEntity applicationEntity);
}
