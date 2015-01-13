package de.hszg.fei.ws.model;

import javax.enterprise.context.Dependent;
import java.util.List;

@Dependent
public class MessageList {

	private List<Message> messageList;

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
}
