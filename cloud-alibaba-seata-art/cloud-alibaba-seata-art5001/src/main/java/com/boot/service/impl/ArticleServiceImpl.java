package com.boot.service.impl;

import com.boot.dao.ArticleMapper;
import com.boot.feign.TagFeign;
import com.boot.service.ArticleService;
import com.boot.service.StatisticService;
import com.github.yitter.contract.IdGeneratorOptions;
import com.pojo.Article;
import com.pojo.Statistic;
import com.pojo.Tag;
import com.util.SnowId;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleServiceImpl implements ArticleService {

  //    private Logger logger=Logger.getLogger(ArticleServiceImpl.class);

  @Autowired private ArticleMapper articleMapper;

  @Autowired private StatisticService statisticService;

  @Autowired private TagFeign tagFeign;

  private IdGeneratorOptions options = new IdGeneratorOptions((short) 1); //雪花算法




//  @Autowired
//  private ArticleService articleService;

  @Override
//  @Transactional
  public void insertArticle(Article article) {
    articleMapper.insertArticle(article);
  }

  /** 这个就是我们发布文章的逻辑，需要受到seata事务管控 */
  /** @GlobalTransactional的名字要唯一 */
  @GlobalTransactional(name = "publishArticle_seata", rollbackFor = Exception.class) // seata全局事务
//  @Transactional
  @Override
  public void publishArticle(Article article, String TagName) {
    System.out.println("开始！！！");
    System.out.println("进入publishArticle");

    //**********************************
    long articleid = SnowId.nextId();
    article.setId(articleid); //***********巨坑，一定要设置id，不然数据库是不是自增id都要设置，不然事务回滚但是数据却没有恢复

//    articleService.insertArticle(article);
    this.insertArticle(article);
    System.out.println("插入文章成功==>" + article);

    Statistic statistic = new Statistic();
    statistic.setId(SnowId.nextId());
    statistic.setArticleid(articleid);
    statistic.setHit(0);
    statisticService.insertStatistic(statistic);

    System.out.println("文章统计数据");


//    int i=10/0; //手动报错

    Tag tag = new Tag();
    //**********************************
    tag.setId(SnowId.nextId());//***********巨坑，一定要设置id，不然数据库是不是自增id都要设置，不然事务回滚但是数据却没有恢复
    tag.setTagName(TagName);
    tagFeign.addArticleTag(tag);

    System.out.println("插入文章标签成功===>" + tag);

    System.out.println("结束！！！");

  }

}
