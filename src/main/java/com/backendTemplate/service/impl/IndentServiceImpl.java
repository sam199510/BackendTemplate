package com.backendTemplate.service.impl;

import com.backendTemplate.dao.IndentDAO;
import com.backendTemplate.entity.Indent;
import com.backendTemplate.service.IndentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fei on 2017/6/26.
 */

@Repository
@Transactional
public class IndentServiceImpl implements IndentServiceI {
    @Autowired
    private IndentDAO indentDAO;

    public void setIndentDAO(IndentDAO indentDAO) {
        this.indentDAO = indentDAO;
    }

    @Override
    public List<Indent> showIsComment(int indentID) {
        return this.indentDAO.showIsComment(indentID);
    }
}
