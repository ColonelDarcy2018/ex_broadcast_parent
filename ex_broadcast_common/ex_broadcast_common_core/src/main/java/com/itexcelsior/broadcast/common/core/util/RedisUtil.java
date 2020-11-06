package com.itexcelsior.broadcast.common.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zxw </br>
 * @create 2020/8/31/13:45 </br>
 * @description: </br>
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 存储String类型
     *
     * @param key
     * @param data
     * @param timeout 秒
     */
    public void setString(String key,String data,Long timeout){
        stringRedisTemplate.opsForValue().set(key,data);
        if (timeout!=null){
            stringRedisTemplate.expire(key,timeout, TimeUnit.SECONDS);
        }
    }
    /**
     * 存储String类型
     *
     * @param key
     * @param data
     */
    public void setString(String key,String data){
        setString(key,data,null);
    }


    /**
     * 根据key查询string类型
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }

    /**
     * 根据对应的key删除key
     *
     * @param key
     */
    public boolean delKey(String key) {
        return stringRedisTemplate.delete(key);
    }


    /**
     * 获取列表信息
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> getList(String key,long start,long end){
        return stringRedisTemplate.opsForList().range(key,start,end);
    }
    /**
     * 获取列表全部信息
     * @param key
     * @return
     */
    public List<String> getListAll(String key){
        return getList(key,0l,getListSize(key));
    }

    /**
     * 获取list大小
     * @param key
     * @return
     */
    public Long getListSize(String key){
        return stringRedisTemplate.opsForList().size(key);
    }

    /**
     * 从List的左侧压入数据，如果不存在key则创建key
     * @param key
     * @param value
     */
    public void leftPushList(String key,String value){

        stringRedisTemplate.opsForList().leftPush(key,value);

    }

    /**
     * 删除list内信息
     * @param key
     * @param count
     * @param value
     */
    public long listRemove(String key,long count,String value){
        return stringRedisTemplate.opsForList().remove(key,count,value);
    }

    /**
     * 删除list内信息,删除一条
     * @param key
     * @param value
     */
    public long listRemove(String key,String value){
        return stringRedisTemplate.opsForList().remove(key,1,value);
    }

}
