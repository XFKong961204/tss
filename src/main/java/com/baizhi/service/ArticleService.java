package com.baizhi.service;

import com.baizhi.entity.Article;

import java.util.List;

public interface ArticleService{
    List<Article> findArticle();
    void modifyArticle(Article article);
    void AddArticle(Article article);
    void removeArticle(String id);
}
