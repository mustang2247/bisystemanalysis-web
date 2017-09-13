package com.bitop.web.bisystemanalysisweb.model.sysmodel.blackip;

import java.util.Date;

/**
 * ip黑名单
 */
public class BlackListIpEntity {

    private int id;
    private String ip;
    private Date iptime; // 日期类型，格式：yyyy-MM-dd HH:mm:ss

    public BlackListIpEntity() {
    }

    public BlackListIpEntity(String ip, Date iptime) {
        this.ip = ip;
        this.iptime = iptime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getIptime() {
        return iptime;
    }

    public void setIptime(Date iptime) {
        this.iptime = iptime;
    }
}
