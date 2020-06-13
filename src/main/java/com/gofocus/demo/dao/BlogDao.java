package com.gofocus.demo.dao;

import com.gofocus.demo.entity.Blog;
import com.gofocus.demo.entity.BlogListResult;
import com.gofocus.demo.entity.Result;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: GoFocus
 * @Date: 2020-06-10 17:14
 * @Description:
 */

@Component
public class BlogDao {

    private final SqlSession sqlSession;

    @Inject
    public BlogDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Blog> getBlogs(Integer page, Integer pageSize, Integer userId) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("pageSize", pageSize);
        map.put("offSet", (page - 1) * pageSize);
        map.put("userId", userId);
        List<Blog> blogs = sqlSession.selectList("getBlogs", map);
        return blogs;
    }


    public Blog getBlogById(Integer blogId) {
        return sqlSession.selectOne("getBlogById", blogId);
    }

    public Blog insertNewBlog(Blog newBlog) {
        sqlSession.insert("insertBlog", newBlog);
        return getBlogById(newBlog.getId());
    }

    public int countBlogs() {
        return sqlSession.selectOne("countBlogs");
    }

    public int deleteBlogById(Integer blogId) {
         return  sqlSession.delete("deleteBlogById", blogId);
    }
}
