package de.hszg.fei.ws.service;

import de.hszg.fei.ws.model.MessageList;
import de.hszg.fei.ws.model.UserWithRecipient;

/**
 * Created by daniel on 17.01.15.
 */
public interface MessageService {
	
	/*bekommt die Message, sollte ein true oder false bei erfolgreich/nichterfolgreich zurückgeben*/
	/*Das Message Objekt enthält Sender, Empfänger, Timestamp und die Nachricht*/
	public boolean saveMessage(String message);
	
	/*bekommt den Sender und Empfänger sowie die Anzahl der Nachrichten, sollte eine Liste mit allen Nachrichten bis numOfMessages zurückgeben*/
	public MessageList getAllMessages(UserWithRecipient users, int numOfMessages);
	
}
