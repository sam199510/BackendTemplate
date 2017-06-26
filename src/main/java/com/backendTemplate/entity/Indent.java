package com.backendTemplate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by fei on 2017/6/26.
 */

@Entity
@Table(name = "indent")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","operations","roles","menus"})
public class Indent {
    private int id;
    private Date bargainTime;
    private String buyerAddress;
    private String bookName;
    private String bookCover;
    private float bookPrice;
    private String bookPublisher;
    private int commentState;
    private long buyerMobile;
    private String buyerName;
    private User indentUser;
    private Book indentBook;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "bargainTime" ,columnDefinition = "datetime", nullable = true)
    public Date getBargainTime() {
        return bargainTime;
    }

    public void setBargainTime(Date bargainTime) {
        this.bargainTime = bargainTime;
    }

    @Column(name = "buyerAddress", columnDefinition = "varchar", length = 300, nullable = true)
    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    @Column(name = "bookName", columnDefinition = "varchar", length = 50, nullable = true)
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Column(name = "bookCover", columnDefinition = "varchar", length = 400, nullable = true)
    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    @Column(name = "bookPrice", columnDefinition = "float", nullable = true)
    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Column(name = "bookPublisher", columnDefinition = "varchar", length = 100, nullable = true)
    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    @Column(name = "commentState", columnDefinition = "int", nullable = true)
    public int getCommentState() {
        return commentState;
    }

    public void setCommentState(int commentState) {
        this.commentState = commentState;
    }

    @Column(name = "buyerMobile", columnDefinition = "bigint", nullable = true)
    public long getBuyerMobile() {
        return buyerMobile;
    }

    public void setBuyerMobile(long buyerMobile) {
        this.buyerMobile = buyerMobile;
    }

    @Column(name = "buyerName", columnDefinition = "varchar", length = 50, nullable = true)
    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyerID")
    @JsonIgnore
    public User getIndentUser() {
        return indentUser;
    }

    public void setIndentUser(User indentUser) {
        this.indentUser = indentUser;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookID")
    @JsonIgnore
    public Book getIndentBook() {
        return indentBook;
    }

    public void setIndentBook(Book indentBook) {
        this.indentBook = indentBook;
    }
}
