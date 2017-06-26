package com.backendTemplate.controller;

import com.backendTemplate.entity.Book;
import com.backendTemplate.entity.Collection;
import com.backendTemplate.entity.User;
import com.backendTemplate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by fei on 2017/6/22.
 */

@Controller
@RequestMapping("/")
public class BTController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    private CollectionService collectionService;

    public void setCollectionService(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @Autowired
    private CommentService commentService ;

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @Autowired
    private IndentServiceI indentServiceI;

    public void setIndentServiceI(IndentServiceI indentServiceI) {
        this.indentServiceI = indentServiceI;
    }

    @RequestMapping("index")
    public ModelAndView indexPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        List<User> users = this.userService.getAllUsers();
        modelAndView.addObject("users",users);

        return  modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView loginPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return  modelAndView;
    }


    @RequestMapping(value = "loginaaa", method = RequestMethod.POST)
    public String loginCheck(String userName, String password) {
        List<User> users = this.userService.checkLogin(userName, password);
        if (users.size() == 0){
            System.out.println("登录失败");
            return "redirect:index.html";
        } else {
            System.out.println("登录成功");
            return "redirect:index.html";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public String isLoginRight(String userName, String password) {
        List<User> users = this.userService.checkLogin(userName,password);
        if (users.size() == 1) {
            session.setAttribute("loginUserName",users.get(0).getUserName());
            return "登录成功";
        } else {
            return "用户名或密码不同！登录失败！";
        }

    }

    @RequestMapping(value = "loginRight", method = RequestMethod.GET)
    public ModelAndView userHomePage(){
        ModelAndView modelAndView = new ModelAndView();

        String userName = (String) session.getAttribute("loginUserName");
        User user = this.userService.findByUserName(userName).get(0);
        int userId = user.getId();
        session.setAttribute("userId", userId);

        modelAndView.setViewName("userHome");
        return  modelAndView;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(){
        session.invalidate();
        return "redirect:login.html";
    }

    @RequestMapping(value = "showBookByPaging", method = RequestMethod.GET)
    public ModelAndView showBookByPagingPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("paging");
        return  modelAndView;
    }

    @RequestMapping(value = "showBookByPaging", method = RequestMethod.POST)
    @ResponseBody
    public List<Book> showBookByPaging(int pageNo, int maxNum){
        return this.bookService.showBookByPaging(pageNo, maxNum);
    }

    @RequestMapping(value = "showAllBooks", method = RequestMethod.POST)
    @ResponseBody
    public List<Book> showAllBooks(){
        return this.bookService.showAllBooks();
    }

    @RequestMapping(value = "showCollectBooksByCollectorID", method = RequestMethod.GET)
    @ResponseBody
    public List<Collection> showCollectBooksByCollectorID(int collectorID){
        return this.collectionService.showCollectBooks(collectorID);
    }

    @RequestMapping(value = "showMyCollectBook", method = RequestMethod.GET)
    @ResponseBody
    public List<User> showMyCollectBook(int collectorID){
        return this.userService.showMyCollectBook(collectorID);
    }

    @RequestMapping(value = "checkIsCollect", method = RequestMethod.GET)
    @ResponseBody
    public String checkIsCollect(int bookID, int collectorID) {
        List<Collection> collections = this.collectionService.checkIsCollect(collectorID, bookID);
        if (collections.size() == 0) {
            return "未收藏";
        } else {
            return "已收藏";
        }
    }

    @RequestMapping(value = "showIsComment", method = RequestMethod.GET)
    @ResponseBody
    public String showIsComment(int indentID){
        int commentState = this.indentServiceI.showIsComment(indentID).get(0).getCommentState();
        if (commentState == 1){
            return "已评价";
        } else {
            return "未评论";
        }
    }
}
