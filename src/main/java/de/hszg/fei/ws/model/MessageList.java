package de.hszg.fei.ws.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

@XmlSeeAlso(Message.class)
@XmlRootElement
public class MessageList {

	private int numMessages;
	
    private List<Message> messageList;

    public int getNumMessages() {
		return numMessages;
	}

	public void setNumMessages(int numMessages) {
		this.numMessages = numMessages;
	}

	public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
