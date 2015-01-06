package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/chatservice")
public class ChatServiceImpl implements ChatService{

	@GET
	@Path("/registryToServer")
	@Consumes("application/json")
	@Override
	public Response registryToServer(User user) {
		return Response.status(200).entity("{\"test\": \"hallo\"}").build();
	}

	@PUT
	@Path("/sendMessage")
	@Consumes("application/json")
	@Override
	public Response sendMessage(Message message) {
		return Response.status(200).entity("{\"test\": \"hallo\"}").build();
	}

	@GET
	@Path("/getAllMessagesForUser")
	@Consumes("application/json")
	@Override
	public Response getAllMessagesForUser(User user) {
		return Response.status(200).entity("{\"test\": \"hallo\"}").build();
	}
}
