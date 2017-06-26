package com.backendTemplate.service;

import com.backendTemplate.dao.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fei on 2017/6/26.
 */

@Repository
@Transactional
public class CommentService {
    @Autowired
    private CommentDAO commentDAO;

    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }
}
