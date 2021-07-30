package com.boot.service.impl;

import com.boot.dao.ArticleMapper;
import com.boot.feign.TagFeign;
import com.boot.service.ArticleService;
import com.boot.service.StatisticService;
import com.pojo.Article;
import com.pojo.Statistic;
import com.pojo.Tag;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

  //    private Logger logger=Logger.getLogger(ArticleServiceImpl.class);

  @Autowired private ArticleMapper articleMapper;

  @Autowired private StatisticService statisticService;

  @Autowired private TagFeign tagFeign;

  @Override
  public void insertArticle(Article article) {
    articleMapper.insertArticle(article);
  }

  /** 这个就是我们发布文章的逻辑，需要受到seata事务管控 */
  /** @GlobalTransactional的名字要唯一 */
  @GlobalTransactional(name = "publishArticle_seata",rollbackFor = Exception.class) //seata全局事务
  @Override
  public void publishArticle(Article article, String TagName) {



    System.out.println("开始！！！");
    System.out.println("进入publishArticle");
    this.insertArticle(article);
    System.out.println("插入文章成功==>" + article);


      Statistic statistic = new Statistic();
      statistic.setArticleid(article.getId());
      statistic.setHit(0);
      statisticService.insertStatistic(statistic);



    System.out.println("文章统计数据");

//    int i=10/0; //手动报错 ====测试通过，事务可以回滚


    Tag tag = new Tag();
    tag.setTagName(TagName);
    tagFeign.addArticleTag(tag);

    System.out.println("插入文章标签成功===>" + tag);

    System.out.println("结束！！！");
  }
}
