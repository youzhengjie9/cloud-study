package com.boot.service;

import com.pojo.Article;

public interface ArticleService {


    void insertArticle(Article article);

    void publishArticle(Article article, String TagName);


}
