package com.boot.service.impl;

import com.boot.dao.StatisticMapper;
import com.boot.service.StatisticService;
import com.pojo.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticMapper statisticMapper;


    @Override
//    @Transactional
    public void insertStatistic(Statistic statistic) {
        statisticMapper.insertStatistic(statistic);
    }


}
