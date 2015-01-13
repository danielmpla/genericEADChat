package de.hszg.fei.ws.repository;

import de.hszg.fei.ws.model.User;
import de.hszg.fei.ws.repository.util.PersistenceRepository;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Daniel on 13.01.2015.
 */
@Dependent
public class UserRepository implements PersistenceRepository<Long, User>, Serializable {
    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction utx;

    @Override
    public User save(User entity) {
        try {
            this.utx.begin();
            if (entity.getId() == null) {
                this.em.persist(entity);
            } else {
                this.em.merge(entity);
            }

            this.utx.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
            e.printStackTrace();
            try {
                this.utx.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
        }

        return entity;
    }

    @Override
    public void remove(User entity) {
        try {
            this.utx.begin();
            this.em.remove(this.em.contains(entity) ? entity : this.em.merge(entity));
            this.utx.commit();
        } catch (NotSupportedException | SystemException | HeuristicRollbackException | HeuristicMixedException | RollbackException e) {
            e.printStackTrace();
            try {
                this.utx.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public User find(Long id) {
        return this.em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return this.em.createQuery("select u from User u")
                .getResultList();
    }

    @Override
    public Long getTotalCount() {
        return (Long) this.em.createQuery("select count(u) from User u")
                .getSingleResult();
    }
}
