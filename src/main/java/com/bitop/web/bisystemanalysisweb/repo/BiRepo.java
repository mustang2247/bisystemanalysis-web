package com.bitop.web.bisystemanalysisweb.repo;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BiRepo extends BaseRepo {

    public BiRepo( ComboPooledDataSource cpds ) {
        this.cpds = cpds;
    }

    public boolean update( String sql, String[] values ) throws SQLException {

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

    public boolean batchUpdate( String sql, List< String[] > values ) throws SQLException {

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
