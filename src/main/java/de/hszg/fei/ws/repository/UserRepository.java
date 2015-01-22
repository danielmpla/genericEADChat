package de.hszg.fei.ws.repository;

import de.hszg.fei.ws.model.repository.UserEntity;
import de.hszg.fei.ws.repository.util.PersistenceRepository;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Daniel on 13.01.2015.
 */
@Dependent
public class UserRepository implements PersistenceRepository<Long, UserEntity>, Serializable {
    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction utx;

    @Override
    public UserEntity save(UserEntity entity) {
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
    public void remove(UserEntity entity) {
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
    public UserEntity find(Long id) {
        return this.em.find(UserEntity.class, id);
    }

    @Override
    public List<UserEntity> findAll() {
        return this.em.createQuery("select u from UserEntity u")
                .getResultList();
    }

    @Override
    public Long getTotalCount() {
        return (Long) this.em.createQuery("select count(u) from UserEntity u")
                .getSingleResult();
    }

    public boolean userIsSaved(Long userId, Long appId) {
        UserEntity user = null;
        try {
            user = (UserEntity) this.em.createQuery("select u from UserEntity u where userID = :userId and application.id = :appId")
                    .setParameter("userId", userId)
                    .setParameter("appId", appId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return false;
        }

        return true;
    }

    public UserEntity find(Long userId, Long appId) {
        return (UserEntity) this.em.createQuery("select u from UserEntity u fetch all properties where userID = :userId and application.id = :appId")
                .setParameter("userId", userId)
                .setParameter("appId", appId)
                .getSingleResult();
    }
}
