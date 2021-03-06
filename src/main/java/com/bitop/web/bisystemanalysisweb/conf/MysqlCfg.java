package com.bitop.web.bisystemanalysisweb.conf;


import com.bitop.common.skeleton.utils.PropUtil;

import java.util.Properties;

public class MysqlCfg {

    public String ADDR;
    public String DB_NAME;
    public String LOGIN_NAME;
    public String LOGIN_PASS;
    public int MAX_CONN;

    public boolean init( String filePath ) {

        Properties props = PropUtil.getProps( filePath );

        ADDR = props.getProperty("mysql.addr").trim();
        DB_NAME = props.getProperty("mysql.db.name").trim();
        LOGIN_NAME = props.getProperty("mysql.login.name").trim();
        LOGIN_PASS = props.getProperty("mysql.login.pass").trim();
        MAX_CONN = Integer.parseInt(props.getProperty("mysql.max.conn").trim());

        return true;
    }
}
