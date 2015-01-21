package de.hszg.fei.ws.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.hszg.fei.ws.model.Message;
import de.hszg.fei.ws.model.MessageList;
import de.hszg.fei.ws.model.User;
import de.hszg.fei.ws.model.UserList;
import de.hszg.fei.ws.model.UserWithRecipient;

@Path("/chatservice")
@RequestScoped
public class ChatServiceImpl implements ChatService{

	@Inject
	private UserService userService;
	@Inject
	private MessageService messageService;

	@POST
	@Path("/registerToServer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response registerToServer(User user) {
		
		UserList userListObject = getAllChatableUsers(user);
		
		return Response.status(200).entity(userListObject).build();
	}

	@POST
	@Path("/sendMessage")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response sendMessage(Message message) {
		boolean isSuccess = saveMessage(message);
		
		return Response.status(200).build();
	}

//	@POST
//	@Path("/getAllMessagesForUser")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Override
//	public Response getAllMessagesForUser(UserWithRecipient userWithRecipient) {
////		MessageList messageListObject = getAllMessagesForUserFromDatabase(users);
//
//		return Response.status(200)/*.entity(messageListObject)*/.build();
//	}
	
	@POST
	@Path("/getMessagesForUser/{numberOfMessages}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getMessagesForUser(UserWithRecipient userWithRecipient, @PathParam("numberOfMessages") int numberOfMessages) {

		MessageList messageList = getAllMessages(userWithRecipient, numberOfMessages);
		
		return Response.status(200).entity(messageList).build();
	}
	
	private UserList getAllChatableUsers(User user){
		UserList userListObject = new UserList();
		List<User> userList = new ArrayList<User>();
		
		//TODO: For-Schleife �ber alle Server, Abfrage der m�glichen User mit dem gegebenen User. 
		//TODO: In jeder Schleife werden die m�glichen User der Liste hinzugef�gt.
		/* userList.add(returnwert der anfrage);*/
		
		//Stub-Daten
		User user1 = new User();
		user1.setUserID("123");
		user1.setAppID("55");
		
		User user2 = new User();
		user2.setUserID("124");
		user2.setAppID("56");
		
		User user3 = new User();
		user3.setUserID("126");
		user3.setAppID("54");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		userListObject.setUserList(userList);
		userListObject.setNumUsers(userList.size());
		
		return userListObject;
	}
}
