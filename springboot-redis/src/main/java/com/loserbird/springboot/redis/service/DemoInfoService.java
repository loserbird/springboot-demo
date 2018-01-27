package com.loserbird.springboot.redis.service;

import com.loserbird.springboot.redis.pojo.DemoInfo;

/**
 * @Author: bingqin
 * @Date: 2018/1/27
 * @Description:
 **/
public interface DemoInfoService {

    public DemoInfo findById(long id);

    public void deleteFromCache(long id);

    public void save(DemoInfo demoInfo);

    void test();
}
