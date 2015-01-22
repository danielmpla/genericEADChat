package de.hszg.fei.ws.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

@XmlSeeAlso(MessageInput.class)
@XmlRootElement
public class MessageList {

	private int numMessages;
	
    private List<MessageInput> messageList;

    public int getNumMessages() {
		return numMessages;
	}

	public void setNumMessages(int numMessages) {
		this.numMessages = numMessages;
	}

	public List<MessageInput> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageInput> messageList) {
        this.messageList = messageList;
    }
}
