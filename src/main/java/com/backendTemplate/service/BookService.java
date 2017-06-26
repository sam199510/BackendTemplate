package com.backendTemplate.service;

import com.backendTemplate.dao.BookDAO;
import com.backendTemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fei on 2017/6/23.
 */

@Repository
@Transactional
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> showBookByPaging(int pageNo, int maxNum) {
        return this.bookDAO.showBookByPaging(pageNo, maxNum);
    }

    public List<Book> showAllBooks(){
        return this.bookDAO.showAllBooks();
    }
}
