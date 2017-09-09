package com.bitop.web.bisystemanalysisweb.model;

import com.bitop.web.bisystemanalysisweb.redis.RedisManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Service
public class ToolsService {
    private static final Logger logger = LoggerFactory.getLogger( ToolsService.class );

    /**
     * 检查是否有该设备了
     * @param type
     * @param key
     * @return
     * 保证bi数据的唯一性
     */
    public boolean check(String type, String key){

        try {
            Jedis jedis = RedisManager.getJedis();
            boolean status = jedis.hexists(type, key);

            if(!status){
                LocalDateTime date = LocalDateTime.now();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                jedis.hmset(type, new HashMap<String, String>(){{put(key, dateTimeFormatter.format(date));}});
            }

            return status;
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return false;
    }
}
