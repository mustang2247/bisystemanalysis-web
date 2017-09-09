package com.bitop.web.bisystemanalysisweb.repo;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SqlRepo extends BaseRepo {

    public SqlRepo( ComboPooledDataSource cpds ) {
        this.cpds = cpds;
    }

    public boolean updateData( String sql ) throws SQLException {
        return update( sql );
    }

    // ================= 合并统计开始 ==================== //

    public long getLong( String sql ) throws SQLException {
        return query( sql, rs -> {
            if( rs.next() ) {
                return rs.getLong( 1 );
            }
            return 0L;
        } );
    }

    public String getString( String sql ) throws SQLException {
        return query( sql, rs -> {
            if( rs.next() ) {
                int cols = rs.getMetaData().getColumnCount();
                String val = "";
                for( int i = 1; i < cols; ++i ) val += rs.getString( i ) + "\n";
                val += rs.getString( cols );
                return val;
            }
            return "";
        } );
    }

    public List< Long > getListLong( String sql ) throws SQLException {
        return query( sql, rs -> {
            List< Long > rv = new LinkedList<>();
            while( rs.next() ) {
                rv.add( rs.getLong( 1 ) );
            }
            return rv;
        } );
    }

    public List< String > getListString( String sql ) throws SQLException {
        return query( sql, rs -> {
            List< String > rv = new LinkedList<>();
            while( rs.next() ) {
                int cols = rs.getMetaData().getColumnCount();
                String val = "";
                for( int i = 1; i < cols; ++i ) val += rs.getString( i ) + "\n";
                val += rs.getString( cols );
                rv.add( val );
            }
            return rv;
        } );
    }

    public Map< Long, Long > getMapLongLong( String sql ) throws SQLException {

        return query( sql, rs -> {
            Map< Long, Long > rv = new TreeMap<>();
            while( rs.next() ) {
                rv.put( rs.getLong( 1 ), rs.getLong( 2 ) );
            }
            return rv;
        } );
    }

    public Map< Long, String > getMapLongString( String sql ) throws SQLException {

        return query( sql, rs -> {
            Map< Long, String > rv = new TreeMap<>();
            while( rs.next() ) {
                int cols = rs.getMetaData().getColumnCount();
                long key = rs.getLong( 1 );
                String val = "";
                for( int i = 2; i < cols; ++i ) val += rs.getString( i ) + "\n";
                val += rs.getString( cols );
                rv.put( key, val );
            }
            return rv;
        } );
    }

    public Map< String, Long > getMapStringLong( String sql ) throws SQLException {

        return query( sql, rs -> {
            Map< String, Long > rv = new TreeMap<>();
            while( rs.next() ) {
                String key = rs.getString( 1 );
                long val = rs.getLong( 2 );
                rv.put( key, val );
            }
            return rv;
        } );
    }

}
