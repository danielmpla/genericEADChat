package de.hszg.fei.ws.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.hszg.fei.ws.model.Message;
import de.hszg.fei.ws.model.MessageList;
import de.hszg.fei.ws.model.User;
import de.hszg.fei.ws.model.UserList;
import de.hszg.fei.ws.model.UserWithRecipient;

@Path("/chatservice")
public class ChatServiceImpl implements ChatService{

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
		boolean isSuccess = putMessageIntoDatabase(message);
		
		return Response.status(200).build();
	}

	@POST
	@Path("/getAllMessagesForUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getAllMessagesForUser(UserWithRecipient userWithRecipient) {
//		MessageList messageListObject = getAllMessagesForUserFromDatabase(users);

		return Response.status(200)/*.entity(messageListObject)*/.build();
	}
	
	@POST
	@Path("/getMessagesForUser/{numberOfMessages}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getMessagesForUser(UserWithRecipient userWithRecipient, @PathParam("numberOfMessages") int numberOfMessages) {

		return Response.status(666).build();
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
		
		return userListObject;
	}
	
	private boolean putMessageIntoDatabase(Message message){
		//TODO: Aufruf an die Datenbank mit dem User, dem Empf�nger und der Message.
		//TODO: Hier muss auch die Meldung an den Appserver gehen, dass eine neue Nachricht f�r den Empf�nger da is.
		
		return true;
	}
	
	/*private MessageList getAllMessagesForUserFromDatabase(UserWithRecipient users){
		MessageList messageListObject = new MessageList();
		List<Message> messageList = new ArrayList<Message>();
		
		//TODO: Aufruf an die Datenbank mit User und Empf�nger
		//TODO: Alle Ergebnisse werden in die messageList eingetragen
		
		//Stub-Daten
		Message message1 = new Message();
		message1.setAppID(users.getAppID());
		message1.setAppIDRecipient(users.getAppIDRecipient());
		message1.setUserID(users.getUserID());
		message1.setUserIDRecipient(users.getUserIDRecipient());
		
		message1.setTimestampe("14-06-2014");
		message1.setMessage("Na was geht?");
		
		Message message2 = new Message();
		message2.setAppIDRecipient(users.getAppID());
		message2.setAppID(users.getAppIDRecipient());
		message2.setUserIDRecipient(users.getUserID());
		message2.setUserID(users.getUserIDRecipient());
		
		message2.setTimestampe("14-06-2014");
		message2.setMessage("Nix und bei dir?");
		
		Message message3 = new Message();
		message3.setAppID(users.getAppID());
		message3.setAppIDRecipient(users.getAppIDRecipient());
		message3.setUserID(users.getUserID());
		message3.setUserIDRecipient(users.getUserIDRecipient());
		
		message3.setTimestampe("14-06-2014");
		message3.setMessage("Auch nix!");
		
		messageList.add(message1);
		messageList.add(message2);
		messageList.add(message3);
		
		messageListObject.setMessageList(messageList);
		
		return messageListObject;
	}*/
	
}
