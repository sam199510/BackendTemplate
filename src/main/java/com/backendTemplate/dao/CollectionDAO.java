package com.backendTemplate.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fei on 2017/6/25.
 */

@Repository
@Transactional
public class CollectionDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List showCollectedBook(int collectorID){
        String hql = "from Collection c where c.collector.id = " + collectorID;
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List checkIsCollect(int collectorID, int bookID){
        String hql = "from Collection c where c.collector.id = " + collectorID + " and c.collectedBook.id = " + bookID;
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

}
