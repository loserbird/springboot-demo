package com.loserbird.springboot.redis.repository;

import com.loserbird.springboot.redis.pojo.DemoInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: bingqin
 * @Date: 2018/1/27
 * @Description:
 **/
public interface DemoInfoRepository extends CrudRepository<DemoInfo,Long> {
}
