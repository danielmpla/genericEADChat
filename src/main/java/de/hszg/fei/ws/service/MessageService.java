package de.hszg.fei.ws.service;

import de.hszg.fei.ws.model.Message;
import de.hszg.fei.ws.model.MessageList;
import de.hszg.fei.ws.model.UserWithRecipient;

/**
 * Created by daniel on 17.01.15.
 */
public interface MessageService {

    /*bekommt die Message, sollte ein true oder false bei erfolgreich/nichterfolgreich zur�ckgeben*/
    /*Das Message Objekt enth�lt Sender, Empf�nger, Timestamp und die Nachricht*/
    public void saveMessage(Message message);

    /*bekommt den Sender und Empf�nger sowie die Anzahl der Nachrichten, sollte eine Liste mit allen Nachrichten bis numOfMessages zur�ckgeben*/
    public MessageList getAllMessages(UserWithRecipient users, int numOfMessages);

}
