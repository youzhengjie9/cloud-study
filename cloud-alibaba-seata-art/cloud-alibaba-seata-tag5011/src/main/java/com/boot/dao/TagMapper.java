package com.boot.dao;

import com.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TagMapper {

    void insertTag(Tag tag);


}
