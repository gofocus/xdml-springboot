package com.gofocus.demo.controller;

import com.gofocus.demo.entity.*;
import com.gofocus.demo.service.AuthService;
import com.gofocus.demo.service.BlogService;
import com.gofocus.demo.utils.AssertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Map;

/**
 * @Author: GoFocus
 * @Date: 2020-06-10 15:39
 * @Description:
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;
    private final AuthService authService;

    @Inject
    public BlogController(BlogService blogService, AuthService authService) {
        this.blogService = blogService;
        this.authService = authService;
    }

    @GetMapping("")
    public BlogListResult getBlog(@RequestParam(value = "page", required = false) Integer page,
                                  @RequestParam(value = "userId", required = false) Integer userId
    ) {

        if (page == null || page < 0) {
            page = 1;
        }

        return blogService.getBlogs(page, 10, userId);

    }

    @GetMapping("/{blogId}")
    public BlogResult getBlogById(@PathVariable("blogId") Integer blogId) {
        return blogService.getBlogById(blogId);
    }

    @PostMapping
    public BlogResult newBlog(@RequestBody Map<String, String> param) {
        try {
            return authService.getCurrentUser()
                    .map(user -> blogService.newBlog(convert2Blog(param, user)))
                    .orElse(BlogResult.failure("登录后才能操作"));
        } catch (Exception e) {
            return BlogResult.failure(e);
        }
    }

    @DeleteMapping("/{blogId}")
    public BlogResult deleteBlgById(@PathVariable("blogId") Integer blogId) {
        try {
            return authService.getCurrentUser()
                    .map(user -> blogService.deleteBlogById(blogId, user.getId()))
                    .orElseGet(() -> BlogResult.failure("登录后才能操作"));
        } catch (Exception e) {
            return BlogResult.failure(e);
        }
    }

    private Blog convert2Blog(Map<String, String> param, User user) {
        String title = param.get("title");
        String content = param.get("content");
        String description = param.get("description");
        AssertUtils.assertTrue(StringUtils.isNotBlank(title) && title.length() < 100, "title is invalid!");
        AssertUtils.assertTrue(StringUtils.isNotBlank(content) && content.length() < 10000, "content is invalid");

        if (StringUtils.isBlank(description)) {
            description = content.substring(0, Math.min(content.length(), 10)) + "...";
        }
        Blog blog = new Blog();
        blog.setContent(content);
        blog.setTitle(title);
        blog.setDescription(description);
        blog.setUser(user);
        return blog;
    }
}
