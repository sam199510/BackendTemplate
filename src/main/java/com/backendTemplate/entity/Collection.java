package com.backendTemplate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by fei on 2017/6/25.
 */

@Entity
@Table(name = "collection")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","operations","roles","menus"})
public class Collection{
    private int id;
    private String bookName;
    private float bookPrice;
    private String bookCover;
    private User collector;
    private Book collectedBook;

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

    @Column(name = "bookName", columnDefinition = "varchar", length = 50, nullable = true)
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Column(name = "bookPrice", columnDefinition = "float", nullable = true)
    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Column(name = "bookCover", columnDefinition = "varchar", length =400 , nullable = true)
    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collectorID")
    @JsonIgnore
    public User getCollector() {
        return collector;
    }

    public void setCollector(User collector) {
        this.collector = collector;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookID")
    @JsonIgnore
    public Book getCollectedBook() {
        return collectedBook;
    }

    public void setCollectedBook(Book collectedBook) {
        this.collectedBook = collectedBook;
    }
}
