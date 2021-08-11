package com.boot.service.impl;

import com.boot.dao.TagMapper;
import com.boot.service.TagService;
import com.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("TagServiceImpl")
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    @Transactional
    public void insertTag(Tag tag) {

        tagMapper.insertTag(tag);

        if(tag.getTagName().equals("back")){
            throw new RuntimeException();
        }
    }
}
