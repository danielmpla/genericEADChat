package de.hszg.fei.ws.repository.util;

import javax.inject.Singleton;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Produces;

@Singleton
public class RepositoryProducer {

    private static EntityManagerFactory factory;

    @Produces
    public EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("de.hszg.fei.ws-PU");
        }
        return factory;
    }
}