package com.gofocus.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.Instant;

/**
 * @Author: GoFocus
 * @Date: 2020-06-07 9:43
 * @Description:
 */
public class User {
    private Integer id;
    private String username;
    private String avatar;
    @JsonIgnore
    private String encryptedPassword;
    private Instant createdAt;
    private Instant updatedAt;

    public User() {
    }

    public User(Integer id, String username, String encryptedPassword) {
        this.id = id;
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    public User(String avatar, String username, Integer id) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
