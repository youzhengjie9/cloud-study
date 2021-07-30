package com.boot.controller;

import com.boot.feign.ArticleFeign;
import com.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/web")
public class WebController {
    /**
     * 客户端的控制器
     */

    @Autowired
    private ArticleFeign articleFeign;




    @ResponseBody
    @GetMapping(path = "/publish/{title}/{tagName}")
    public String publish(@PathVariable("title") String title,@PathVariable("tagName") String tagName){
        Article article = new Article();
        article.setTitle(title);
        articleFeign.publishArticle(article,tagName); //利用feign去远程调用Aritcle服务接口

        return "publish--success";

    }


}
