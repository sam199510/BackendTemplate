package com.backendTemplate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fei on 2017/6/26.
 */

@Repository
@Transactional
public class CommentDAO {
    @Autowired
    private SessionFactory sessionFactory;
}
