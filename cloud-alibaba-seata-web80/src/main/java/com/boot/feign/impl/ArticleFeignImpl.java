package com.boot.feign.impl;

import com.boot.feign.ArticleFeign;
import com.pojo.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleFeignImpl implements ArticleFeign {


    @Override
    public String publishArticle(Article article, String tagName) {
        throw new RuntimeException("ArticleFeignImpl----fallback");
    }
}
