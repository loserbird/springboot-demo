package com.loserbird.springboot.redis.service;

import com.loserbird.springboot.redis.pojo.DemoInfo;
import com.loserbird.springboot.redis.repository.DemoInfoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: bingqin
 * @Date: 2018/1/27
 * @Description:
 **/
@Service
public class DemoInfoServiceImpl implements DemoInfoService {

    @Resource
    private DemoInfoRepository demoInfoRepository;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void test(){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykey4", "random1="+Math.random());
        System.out.println(valueOperations.get("mykey4"));
    }

    //keyGenerator="myKeyGenerator"
    @Cacheable(value="demoInfo",key="'demoInfo' + #p0") //缓存,这里没有指定key.
    @Override
    public DemoInfo findById(long id) {
        System.err.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....id="+id);
        return demoInfoRepository.findOne(id);
    }

    @CacheEvict(value="demoInfo",key="'demoInfo' + #p0")
    @Override
    public void deleteFromCache(long id) {
        System.out.println("DemoInfoServiceImpl.delete().id="+id+"从缓存中删除.");
    }

    @CachePut(value="demoInfo",key="'demoInfo' + #p0.id")
    @Override
    public void save(DemoInfo demoInfo) {
        demoInfoRepository.save(demoInfo);
    }

}

