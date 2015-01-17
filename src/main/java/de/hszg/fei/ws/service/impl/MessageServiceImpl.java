package de.hszg.fei.ws.service.impl;

import de.hszg.fei.ws.repository.MessageRepository;
import de.hszg.fei.ws.service.MessageService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by daniel on 17.01.15.
 */
@Dependent
public class MessageServiceImpl implements MessageService, Serializable {
    @Inject
    private MessageRepository repository;
}
