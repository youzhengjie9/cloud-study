package com.util;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;

import java.io.Serializable;

public class SnowId implements Serializable {

    private static IdGeneratorOptions options = new IdGeneratorOptions((short) 1); //雪花算法

    static {
        /**
         * 默认为6：50w并发需要8秒
         * 设置为10：50w并发只需要0.5秒，提升巨大
         */
        options.SeqBitLength=10;
        YitIdHelper.setIdGenerator(options);
    }

    //雪花算法生成分布式id
    public static long nextId(){

        return YitIdHelper.nextId();
    }

}
