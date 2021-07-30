package com.boot.feign.impl;

import com.boot.feign.TagFeign;
import com.data.CommonData;
import com.pojo.Tag;
import org.springframework.stereotype.Component;

@Component
public class TagFeignImpl implements TagFeign {


  @Override
  public CommonData<Tag> addArticleTag(Tag tag) {
    System.out.println("TagFeign异常回滚");
    // 这里必须要进行特定的处理，不然seata的分布式事务会失效，因为seata的分布式事务是根据异常来的，有异常才会回滚
    throw new RuntimeException("TagFeign异常回滚");
  }
}
