package com.backendTemplate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fei on 2017/6/23.
 */

@Entity
@Table(name = "book")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","operations","roles","menus"})
public class Book{
    private int id;
    private String bookName;
    private String author;
    private float price;
    private String introduce;
    private String publisher;
    private long isbn;
    private int repertory;
    private String cover;
    private int type;
    private Set<Collection> bookCollections = new HashSet<Collection>(0);
    private Set<Indent> bookIndents = new HashSet<Indent>(0);
    private Set<Comment> bookComments = new HashSet<Comment>(0);

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

    @Column(name = "author", columnDefinition = "varchar", length = 100, nullable = true)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "price", columnDefinition = "float", nullable = true)
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Column(name = "introduce", columnDefinition = "varchar", length = 500, nullable = true)
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Column(name = "publisher", columnDefinition = "varchar", length = 100, nullable = true)
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Column(name = "isbn", columnDefinition = "bigint", nullable = true)
    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    @Column(name = "repertory", columnDefinition = "int", nullable = true)
    public int getRepertory() {
        return repertory;
    }

    public void setRepertory(int repertory) {
        this.repertory = repertory;
    }

    @Column(name = "cover", columnDefinition = "varchar", length = 400, nullable = true)
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Column(name = "type", columnDefinition = "int", nullable = true)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "collectedBook")
    @JsonIgnore
    public Set<Collection> getBookCollections() {
        return bookCollections;
    }

    public void setBookCollections(Set<Collection> bookCollections) {
        this.bookCollections = bookCollections;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "indentBook")
    @JsonIgnore
    public Set<Indent> getBookIndents() {
        return bookIndents;
    }

    public void setBookIndents(Set<Indent> bookIndents) {
        this.bookIndents = bookIndents;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "commentedBook")
    @JsonIgnore
    public Set<Comment> getBookComments() {
        return bookComments;
    }

    public void setBookComments(Set<Comment> bookComments) {
        this.bookComments = bookComments;
    }
}
