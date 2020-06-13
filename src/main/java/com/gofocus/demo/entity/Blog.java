package com.gofocus.demo.entity;

import java.time.Instant;

/**
 * @Author: GoFocus
 * @Date: 2020-06-10 15:48
 * @Description:
 */


public class Blog {
    private Integer id;
    private String title;
    private String content;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private User user;

    public Integer getUserId() {
        return user == null ? null : user.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
