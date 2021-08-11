package com.boot.controller;

import com.boot.service.TagService;
import com.data.CommonData;
import com.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @ResponseBody
    @PostMapping(path = "/addArticleTag")
    public CommonData<Tag> addArticleTag(@RequestBody Tag tag){


        tagService.insertTag(tag);


        CommonData<Tag> data = new CommonData<>();
        data.setCode(200);
        data.setMsg("success");
        data.setData(tag);
        return data;
    }

}
