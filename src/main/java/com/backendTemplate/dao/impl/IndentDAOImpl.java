package com.backendTemplate.dao.impl;

import com.backendTemplate.dao.IndentDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fei on 2017/6/26.
 */

@Repository
@Transactional
public class IndentDAOImpl implements IndentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List showIsComment(int indentID) {
        String hql = "from Indent i where i.id = " + indentID;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }
}
