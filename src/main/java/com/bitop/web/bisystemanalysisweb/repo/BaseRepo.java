package com.bitop.web.bisystemanalysisweb.repo;

import com.bitop.web.bisystemanalysisweb.interfaces.ResultProcessor;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseRepo {

    protected static final Logger logger = LoggerFactory.getLogger( BaseRepo.class );

    protected ComboPooledDataSource cpds;

    public String boolString( boolean b ) {
        return b ? "Y" : "N";
    }

    public String safeString( String s ) {
        return s == null ? "" : s;
    }

    public boolean update( String sql ) throws SQLException {
        Connection conn = null;
        PreparedStatement preState = null;

        try {
            long BEG = System.currentTimeMillis();
            conn = cpds.getConnection();
            preState = conn.prepareStatement( sql );
            return preState.executeUpdate() > 0;
        }
        catch( Exception e ) {
            logger.error( e.getMessage() + " SQL = " + sql, e );
            return false;
        }
        finally {
            if( preState != null ) preState.close();
            if( conn != null ) conn.close();
        }
    }

    public < T > T query( String sql, ResultProcessor< T > processor ) throws SQLException {

        Connection conn = null;
        PreparedStatement preState = null;
        ResultSet rs = null;

        try {
            long BEG = System.currentTimeMillis();
            conn = cpds.getConnection();
            preState = conn.prepareStatement( sql );
            rs = preState.executeQuery();
            long END = System.currentTimeMillis();
            if( END - BEG > 500L ) {
                logger.debug( "SLOW QUERY [{}] cost {} ms", sql, END - BEG );
            }
            return processor.process( rs );
        }
        catch( Exception e ) {
            logger.error( e.getMessage() + " SQL = " + sql, e );
            return null;
        }
        finally {
            if( rs != null ) rs.close();
            if( preState != null ) preState.close();
            if( conn != null ) conn.close();
        }

    }

}
