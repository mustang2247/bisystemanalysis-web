package com.bitop.web.bisystemanalysisweb.repo;


import com.bitop.web.bisystemanalysisweb.conf.MysqlCfg;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class RepoManager {

    private static ComboPooledDataSource cpds;
    private static BiRepo biRepo;

    public static UserSqlRepo getUserSqlRepo() {
        return userSqlRepo;
    }

    private static UserSqlRepo userSqlRepo;
    private static SqlRepo sqlRepo;

    public static boolean init( String filePath ) throws PropertyVetoException, SQLException {
        MysqlCfg config = new MysqlCfg();
        config.init( filePath );

        cpds = new ComboPooledDataSource( "BiServer" );
        cpds.setDriverClass( "com.mysql.jdbc.Driver" );
        cpds.setJdbcUrl( "jdbc:mysql://" + config.ADDR + "/" + config.DB_NAME + "?useUnicode=true&characterEncoding=utf-8&useSSL=false" );
        cpds.setUser( config.LOGIN_NAME );
        cpds.setPassword( config.LOGIN_PASS );
        cpds.setInitialPoolSize( config.MAX_CONN );
        cpds.setMaxPoolSize( config.MAX_CONN );
        cpds.setForceSynchronousCheckins( true );
        cpds.setIdleConnectionTestPeriod( 60 );
        cpds.setPreferredTestQuery( "select 1;" );
        for( int i = 0; i < config.MAX_CONN; ++i ) {
            cpds.getConnection().close();
        }

        biRepo = new BiRepo( cpds );
        sqlRepo = new SqlRepo( cpds );
        userSqlRepo = new UserSqlRepo( cpds );

        return true;
    }

    public static BiRepo getBiRepo() {
        return biRepo;
    }

    public static SqlRepo getSqlRepo() {
        return sqlRepo;
    }

    public static void shutdown() {
        if( cpds != null ) cpds.close();
    }
}
