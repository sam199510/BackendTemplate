package com.backendTemplate.dao;

import com.backendTemplate.entity.Book;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fei on 2017/6/23.
 */

@Repository
@Transactional
public class BookDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List showBookByPaging(int pageNo, int maxNum){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
        criteria.setFirstResult(pageNo * maxNum).setMaxResults(maxNum);
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List showAllBooks(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
        return criteria.list();
    }
}
