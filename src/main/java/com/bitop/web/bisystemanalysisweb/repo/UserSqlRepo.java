package com.bitop.web.bisystemanalysisweb.repo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserSqlRepo extends BaseRepo {
    private static final Logger logger = LoggerFactory.getLogger(UserSqlRepo.class);

    public UserSqlRepo(ComboPooledDataSource cpds) {
        this.cpds = cpds;
    }

    public boolean update( String sql, String[] values ) throws SQLException {

        Connection conn = null;
        PreparedStatement preState = null;

        try {
            conn = cpds.getConnection();
            preState = conn.prepareStatement( sql );

            int pos = 1;
            for( int i = 3; i < values.length; i++ ) {
                preState.setString( pos, values[i] );
//                logger.info("pos:  " + pos + "   values: " + values[i]);
                ++pos;
            }

            preState.setString(pos, values[0]);
//            logger.info("pos:  " + pos + "   values: " + values[0]);
            ++pos;
            preState.setString(pos, values[1]);
//            logger.info("pos:  " + pos + "   values: " + values[1]);
            ++pos;
            preState.setString(pos, values[2]);
//            logger.info("pos:  " + pos + "   values: " + values[2]);

            int rowsAffected = preState.executeUpdate();
            return rowsAffected == 1;
        }
        finally {
            if( preState != null ) preState.close();
            if( conn != null ) conn.close();
        }
    }

    /**
     * 查询
     * @param sql
     * @param values
     * @return
     * @throws SQLException
     */
    public int select( String sql, String[] values ) throws SQLException {
        Connection conn = null;
        PreparedStatement preState = null;

        try {
            conn = cpds.getConnection();
            preState = conn.prepareStatement( sql );

            int pos = 1;
            for( String x : values ) {
                preState.setString( pos, x );
                ++pos;
            }

            ResultSet rowsAffected = preState.executeQuery();
            if(rowsAffected.next()){
                return rowsAffected.getInt(1);
            }
        }
        finally {
            if( preState != null ) preState.close();
            if( conn != null ) conn.close();
        }

        return -1;
    }

    public boolean insert( String sql, String[] values ) throws SQLException {

        Connection conn = null;
        PreparedStatement preState = null;

        try {
            conn = cpds.getConnection();
            preState = conn.prepareStatement( sql );

            int pos = 1;
            for( String x : values ) {
                preState.setString( pos, x );
                ++pos;
            }

            int rowsAffected = preState.executeUpdate();
            return rowsAffected == 1;
        }
        finally {
            if( preState != null ) preState.close();
            if( conn != null ) conn.close();
        }
    }

    public boolean batchInsert( String sql, List< String[] > values ) throws SQLException {

        Connection conn = null;
        PreparedStatement preState = null;

        try {
            long BEG = System.currentTimeMillis();
            conn = cpds.getConnection();
            preState = conn.prepareStatement( sql );

            int pos = 1;
            for( String[] val : values ) {
                for( String x : val ) {
                    preState.setString( pos, x );
                    ++pos;
                }
            }
            long MID = System.currentTimeMillis();
            int rowsAffected = preState.executeUpdate();
            long END = System.currentTimeMillis();
            logger.debug( "BiRepo::batchUpdate cost {} {}", MID - BEG, END - MID );
            return rowsAffected == values.size();
        }
        catch( SQLException e ) {
            logger.error( e.getMessage() + "SQL = " + sql, e );
            throw e;
        }
        finally {
            if( preState != null ) preState.close();
            if( conn != null ) conn.close();
        }
    }

}
