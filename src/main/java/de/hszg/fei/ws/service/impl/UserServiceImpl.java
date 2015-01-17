package de.hszg.fei.ws.service.impl;

import de.hszg.fei.ws.repository.UserRepository;
import de.hszg.fei.ws.service.UserService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by daniel on 17.01.15.
 */
@Dependent
public class UserServiceImpl implements UserService, Serializable {
    @Inject
    private UserRepository repository;
}
