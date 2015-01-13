package de.hszg.fei.ws.repository.util;

import java.util.List;

public interface PersistenceRepository<K, E> {
    E save(E entity);

    void remove(E entity);

    E find(K id);

    List<E> findAll();

    Long getTotalCount();
}