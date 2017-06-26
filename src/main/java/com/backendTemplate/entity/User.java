package com.backendTemplate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fei on 2017/6/22.
 */

@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","operations","roles","menus"})
public class User{
    private int id;
    private String userName;
    private String password;
    private long mobile;
    private String address;
    private Set<Collection> userCollections = new HashSet<Collection>(0);
    private Set<Indent> userIndents = new HashSet<Indent>(0);
    private Set<Comment> userComments = new HashSet<Comment>(0);

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

    @Column(name = "userName", columnDefinition = "varchar", length = 50, nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password", columnDefinition = "varchar", length = 30, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "mobile", columnDefinition = "bigint", length = 20, nullable = true)
    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    @Column(name = "address", columnDefinition = "varchar", length = 300, nullable = true)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "collector")
    @JsonIgnore
    public Set<Collection> getUserCollections() {
        return userCollections;
    }

    public void setUserCollections(Set<Collection> userCollections) {
        this.userCollections = userCollections;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "indentUser")
    @JsonIgnore
    public Set<Indent> getUserIndents() {
        return userIndents;
    }

    public void setUserIndents(Set<Indent> userIndents) {
        this.userIndents = userIndents;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "commentor")
    @JsonIgnore
    public Set<Comment> getUserComments() {
        return userComments;
    }

    public void setUserComments(Set<Comment> userComments) {
        this.userComments = userComments;
    }
}
