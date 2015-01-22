package de.hszg.fei.ws.repository;

import de.hszg.fei.ws.model.repository.MessageEntity;
import de.hszg.fei.ws.model.repository.UserEntity;
import de.hszg.fei.ws.repository.util.PersistenceRepository;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Daniel on 12.01.2015.
 */
@Dependent
public class MessageRepository implements PersistenceRepository<Long, MessageEntity>, Serializable {
    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction utx;

    @Override
    public MessageEntity save(MessageEntity entity) {
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
    public void remove(MessageEntity entity) {
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
    public MessageEntity find(Long id) {
        return this.em.find(MessageEntity.class, id);
    }

    @Override
    public List<MessageEntity> findAll() {
        return this.em.createQuery("select m from MessageEntity m")
                .getResultList();
    }

    @Override
    public Long getTotalCount() {
        return (Long) this.em.createQuery("select count(m) from MessageEntity m")
                .getSingleResult();
    }

    public List<MessageEntity> find(UserEntity user, UserEntity recipient) {
        return this.em.createQuery("select m from MessageEntity m where (user = :user and recipient = :recipient) or (user = :recipient and recipient = :user) order by timestamp desc")
                .setParameter("user", user)
                .setParameter("recipient", recipient)
                .getResultList();
    }
}
