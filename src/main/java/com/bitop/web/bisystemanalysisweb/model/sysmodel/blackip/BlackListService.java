package com.bitop.web.bisystemanalysisweb.model.sysmodel.blackip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ip黑名单过滤service
 */
@Service
public class BlackListService {
    private static final Logger logger = LoggerFactory.getLogger( BlackListService.class );

    /**
     * 获取相应IP信息
     * @param ip
     * @return
     */
    public List<BlackListIpEntity> getBlackList(String ip) {
        logger.info(ip);
        return null;
    }

    /**
     * 添加ip过滤
     * @param blackListIpEntity
     */
    public void addBlackList(BlackListIpEntity blackListIpEntity){
        logger.info(blackListIpEntity.getIp() + "  :   " + blackListIpEntity.getIptime());
    }

}
