package com.backendTemplate.service;

import com.backendTemplate.dao.UserDAO;
import com.backendTemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fei on 2017/6/22.
 */

@Repository
@Transactional
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers(){
        return this.userDAO.getAllUsers();
    }

    public List<User> checkLogin(String userName, String password) {
        return this.userDAO.loginCheck(userName, password);
    }

    public List<User> findByUserName(String userName) {
        return this.userDAO.findByUserName(userName);
    }
}
