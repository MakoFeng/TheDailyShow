package com.makofeng.dailyshow.model;

/**
 * 文章model
 * Created by 冯浩 on 2015/6/4.
 */
public class Article {

    public static final int ALL = 1;
    public static final int IMAGE_TEXT = 2;

    /**
     * 文章ID
     */
    private String articleId;
    /**
     * 文章类型
     */
    private int category;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 文章时间
     */
    private String time;
    /**
     * 文章作者
     */
    private String author;


    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", category=" + category +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
