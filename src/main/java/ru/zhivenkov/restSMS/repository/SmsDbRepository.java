package ru.zhivenkov.restSMS.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class SmsDbRepository {

    @PersistenceContext
    EntityManager em;

    public List<SmsDb> findSmsByAuthorId(int authorId){
        /**
         * Поиск СМС по автору с заданным ID,
         * в соответствии с переданным id автора
         * @param authorId - id автора СМС
         * @return - список СМС
         */

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SmsDb> cq = cb.createQuery(SmsDb.class);

        Root<SmsDb> sms = cq.from(SmsDb.class);
        Predicate authorNamePredicate = cb.equal(sms.get("creatorId"), authorId);
        cq.where(authorNamePredicate);

        TypedQuery<SmsDb> query = em.createQuery(cq);
        return query.getResultList();
    }
}
