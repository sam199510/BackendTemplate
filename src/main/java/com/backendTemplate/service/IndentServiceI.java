package com.backendTemplate.service;

import com.backendTemplate.entity.Indent;

import java.util.List;

/**
 * Created by fei on 2017/6/26.
 */
public interface IndentServiceI {
    public List<Indent> showIsComment(int indentID);
}
