package com.boot.controller;

import com.boot.service.ArticleService;
import com.data.CommonData;
import com.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @ResponseBody
    @PostMapping("/publishArticle")
    public String publishArticle(@RequestBody Article article,@RequestParam("tagName") String tagName){

    // 测试接口
//    System.out.println(article);
//    System.out.println(tagName);

        articleService.publishArticle(article,tagName);

        return "publishArticle---success";
    }

}
