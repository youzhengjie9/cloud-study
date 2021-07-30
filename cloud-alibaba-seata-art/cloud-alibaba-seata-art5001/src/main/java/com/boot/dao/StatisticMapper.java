package com.boot.dao;

import com.pojo.Statistic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StatisticMapper {

    void insertStatistic(Statistic statistic);

}
