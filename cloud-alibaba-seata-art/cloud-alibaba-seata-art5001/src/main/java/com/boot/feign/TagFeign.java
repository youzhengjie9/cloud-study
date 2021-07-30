package com.boot.feign;

import com.boot.feign.impl.TagFeignImpl;
import com.data.CommonData;
import com.pojo.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "cloud-alibaba-seata-tag",fallback = TagFeignImpl.class)
@Component
public interface TagFeign {

    @ResponseBody
    @PostMapping(path = "/tag/addArticleTag")
    public CommonData<Tag> addArticleTag(@RequestBody Tag tag);

}
