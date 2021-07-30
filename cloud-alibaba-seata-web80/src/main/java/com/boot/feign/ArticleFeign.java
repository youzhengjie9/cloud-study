package com.boot.feign;

import com.boot.feign.impl.ArticleFeignImpl;
import com.pojo.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "cloud-alibaba-seata-article",fallback = ArticleFeignImpl.class)
@Component
public interface ArticleFeign {

    @ResponseBody
    @PostMapping("/article/publishArticle")
    public String publishArticle(@RequestBody Article article,@RequestParam("tagName") String tagName);


}
