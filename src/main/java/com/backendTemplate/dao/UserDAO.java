package com.backendTemplate.dao;

import com.backendTemplate.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fei on 2017/6/22.
 */

@Repository
@Transactional
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List getAllUsers(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List loginCheck(String userName, String password) {
        String hql = "from User u where u.userName = '" + userName + "' and u.password = '" + password + "'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return  query.list();
    }

    @SuppressWarnings("unchecked")
    public List findByUserName(String userName){
        String hql = "from User u where u.userName = '" + userName + "'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }


}
