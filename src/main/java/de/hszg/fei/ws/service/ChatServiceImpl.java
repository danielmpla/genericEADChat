package de.hszg.fei.ws.service;

import de.hszg.fei.ws.model.*;
import de.hszg.fei.ws.model.repository.UserEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/chatservice")
@RequestScoped
public class ChatServiceImpl implements ChatService {

    @Inject
    private UserService userService;
    @Inject
    private MessageService messageService;
    @Inject
    private ApplicationService applicationService;

    @POST
    @Path("/registerToServer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response registerToServer(User user) {
        UserEntity userEntity;

        if (!this.userService.userIsSaved(user)) {
            userEntity = this.userService.save(user);
        } else {
            userEntity = this.userService.find(user);
        }

        UserList userListObject = this.applicationService.findAllChatAbleUsers(user);

        return Response.status(200).entity(userListObject).build();
    }

    @POST
    @Path("/sendMessage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response sendMessage(Message message) {
        this.messageService.saveMessage(message);
        this.applicationService.notifyServer(message);

        return Response.status(200).build();
    }

    @POST
    @Path("/getMessagesForUser/{numberOfMessages}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response getMessagesForUser(UserWithRecipient userWithRecipient, @PathParam("numberOfMessages") int numberOfMessages) {

        MessageList messageList = this.messageService.getAllMessages(userWithRecipient, numberOfMessages);

        return Response.status(200).entity(messageList).build();
    }
}
