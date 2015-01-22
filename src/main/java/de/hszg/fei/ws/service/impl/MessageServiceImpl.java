package de.hszg.fei.ws.service.impl;

import de.hszg.fei.ws.model.Message;
import de.hszg.fei.ws.model.MessageList;
import de.hszg.fei.ws.model.User;
import de.hszg.fei.ws.model.UserWithRecipient;
import de.hszg.fei.ws.model.repository.MessageEntity;
import de.hszg.fei.ws.model.repository.UserEntity;
import de.hszg.fei.ws.repository.MessageRepository;
import de.hszg.fei.ws.repository.UserRepository;
import de.hszg.fei.ws.service.MessageService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by daniel on 17.01.15.
 */
@Dependent
public class MessageServiceImpl implements MessageService, Serializable {
    @Inject
    private MessageRepository repository;
    @Inject
    private UserRepository userRepository;

    @Override
    public void saveMessage(Message message) {
        UserEntity user = this.userRepository.find(message.getUser().getUserId(), message.getUser().getAppId());
        UserEntity recipient = this.userRepository.find(message.getRecipient().getUserId(), message.getRecipient().getAppId());

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessage(message.getMessage());
        messageEntity.setUser(user);
        messageEntity.setRecipient(recipient);
        messageEntity.setTimestamp(new Date(message.getTimestamp()));

        this.repository.save(messageEntity);
    }

    @Override
    public MessageList getAllMessages(UserWithRecipient users, int numOfMessages) {
        UserEntity user = this.userRepository.find(users.getUser().getUserId(), users.getUser().getAppId());
        UserEntity recipient = this.userRepository.find(users.getRecipient().getUserId(), users.getRecipient().getAppId());

        List<MessageEntity> messageEntities = this.repository.find(user, recipient);

        List<Message> messages = new ArrayList<>();

        if (messageEntities.size() != 0) {

            if (numOfMessages > messageEntities.size()) {
                numOfMessages = messageEntities.size();
            }

            for (MessageEntity messageEntity : messageEntities.subList(0, numOfMessages)) {
                Message message = new Message();
                User user1 = new User();
                User recipient1 = new User();

                user1.setUserId(messageEntity.getUser().getUserID());
                user1.setUsername(messageEntity.getUser().getUsername());
                user1.setAppId(messageEntity.getUser().getApplication().getId());

                recipient1.setUserId(messageEntity.getRecipient().getUserID());
                recipient1.setUsername(messageEntity.getRecipient().getUsername());
                recipient1.setAppId(messageEntity.getRecipient().getApplication().getId());

                message.setMessage(messageEntity.getMessage());
                message.setRecipient(recipient1);
                message.setUser(user1);
                message.setTimestamp(messageEntity.getTimestamp().getTime());

                messages.add(message);
            }
        }

        MessageList messageList = new MessageList();
        messageList.setMessageList(messages);

        return messageList;
    }
}
