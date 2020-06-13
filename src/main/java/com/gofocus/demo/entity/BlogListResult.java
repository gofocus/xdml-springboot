package com.gofocus.demo.entity;

import java.util.List;

/**
 * @Author: GoFocus
 * @Date: 2020-06-10 15:46
 * @Description:
 */

public class BlogListResult extends Result<List<Blog>> {
    private Integer total;
    private Integer page;
    private Integer totalPage;

    public static BlogListResult success(List<Blog> data, Integer total, Integer page, Integer totalPage) {
        return new BlogListResult(ResultStatus.OK, "获取成功", total, page, totalPage, data);
    }

    public static BlogListResult failure(String msg) {
        return new BlogListResult(ResultStatus.FAIL, msg, 0, 0, 0, null);
    }

    public BlogListResult(ResultStatus status, String msg, Integer total, Integer page, Integer totalPage, List<Blog> blogs) {
        super(status, msg, blogs);
        this.page = page;
        this.total = total;
        this.totalPage = totalPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

}
