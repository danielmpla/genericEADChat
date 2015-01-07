package de.hszg.fei.ws.service;

import javax.ws.rs.core.Response;

public interface ChatService {

	public Response registryToServer(User user);
	
	public Response sendMessage(Message message);
	
	public Response getAllMessagesForUser(User user);
}
