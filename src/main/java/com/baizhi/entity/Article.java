package com.baizhi.entity;

import java.util.Date;

/**
 * 文章表
 */
public class Article {
    private String article_id;
    private String title;
    private String  content;
    private String figurePath;
    private Date publishDate;

    public Article() {
    }

    public Article(String article_id, String title, String content, String figurePath, Date publishDate) {
        this.article_id = article_id;
        this.title = title;
        this.content = content;
        this.figurePath = figurePath;
        this.publishDate = publishDate;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
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

    public String getFigurePath() {
        return figurePath;
    }

    public void setFigurePath(String figurePath) {
        this.figurePath = figurePath;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "article_id='" + article_id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", figurePath='" + figurePath + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
