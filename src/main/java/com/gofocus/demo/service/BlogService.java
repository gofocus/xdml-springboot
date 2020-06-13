package com.gofocus.demo.service;

import com.gofocus.demo.dao.BlogDao;
import com.gofocus.demo.entity.Blog;
import com.gofocus.demo.entity.BlogListResult;
import com.gofocus.demo.entity.BlogResult;
import com.gofocus.demo.entity.Result;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @Author: GoFocus
 * @Date: 2020-06-10 15:42
 * @Description:
 */

@Service
public class BlogService {

    private BlogDao blogDao;

    @Inject
    public BlogService(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    public BlogListResult getBlogs(Integer page, int pageSize, Integer userId) {
        try {
            List<Blog> blogs = blogDao.getBlogs(page, pageSize, userId);
            int blogCount = blogDao.countBlogs();
            Integer totalPage = (blogCount + pageSize - 1) / pageSize;
            return new BlogListResult(Result.ResultStatus.OK, "获取成功", blogCount, page, totalPage, blogs);

        } catch (Exception e) {
            e.printStackTrace();
            return BlogListResult.failure("系统异常");
        }
    }

    public BlogResult getBlogById(Integer blogId) {
        try {
            return BlogResult.success("获取成功", blogDao.getBlogById(blogId));
        } catch (Exception e) {
            return BlogResult.failure("系统异常");
        }
    }

    public BlogResult newBlog(Blog blog) {
        try {
            return BlogResult.success("创建成功", blogDao.insertNewBlog(blog));
        } catch (Exception e) {
            return BlogResult.failure(e);
        }
    }

    public BlogResult deleteBlogById(Integer blogId, Integer currentUserId) {
        Blog blog = blogDao.getBlogById(blogId);
        if (blog == null) {
            return BlogResult.failure("博客不存在");
        }

        if (!blog.getUser().getId().equals(currentUserId)) {
            return BlogResult.failure("无法删除别人的博客");
        }
        try {
            blogDao.deleteBlogById(blogId);
            return BlogResult.success("删除成功");
        } catch (Exception e) {
            return BlogResult.failure(e);
        }
    }
}
