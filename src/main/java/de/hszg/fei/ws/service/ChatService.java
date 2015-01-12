package de.hszg.fei.ws.service;

import javax.ws.rs.core.Response;

import de.hszg.fei.ws.model.Message;
import de.hszg.fei.ws.model.User;
import de.hszg.fei.ws.model.UserWithRecipient;

public interface ChatService {

	public Response registerToServer(User user);
	
	public Response sendMessage(Message message);
	
	public Response getAllMessagesForUser(UserWithRecipient users);
	
	public Response getMessagesForUser(UserWithRecipient user, int numberOfMessages);
}
