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
@Table(name = "comment")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","operations","roles","menus"})
public class Comment {
    private int id;
    private Date commentTime;
    private String content;
    private String buyerName;
    private User commentor;
    private Book commentedBook;

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

    @Column(name = "commentTime", columnDefinition = "date", nullable = true)
    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Column(name = "content", columnDefinition = "varchar", length = 400, nullable = true)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    public User getCommentor() {
        return commentor;
    }

    public void setCommentor(User commentor) {
        this.commentor = commentor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookID")
    @JsonIgnore
    public Book getCommentedBook() {
        return commentedBook;
    }

    public void setCommentedBook(Book commentedBook) {
        this.commentedBook = commentedBook;
    }
}
