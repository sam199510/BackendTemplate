package com.backendTemplate.entity;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by fei on 2017/6/22.
 */

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column private String userName;
    @Column private String password;
    @Column private long mobile;
    @Column private String address;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
