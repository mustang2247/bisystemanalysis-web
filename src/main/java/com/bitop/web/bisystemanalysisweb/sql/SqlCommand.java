package com.bitop.web.bisystemanalysisweb.sql;


import com.bitop.web.bisystemanalysisweb.repo.RepoManager;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SqlCommand {

    public String sql;
    public String batchSql;
    public String paramPattern;
    public int paramCount;
    public int batchCount;
    public List< String[] > values;

    public SqlCommand() {
        values = new LinkedList< String[] >();
    }

    public boolean init() {
        if( batchCount < 1 ) return false;
        StringBuilder sb = new StringBuilder();
        sb.append( sql );
        for( int i = 0; i < batchCount; ++i ) {
            sb.append( paramPattern ).append( i == batchCount - 1 ? ";" : "," );
        }
        batchSql = sb.toString();
        sql = sql + paramPattern + ";";
        return true;
    }

    public boolean push( String[] val ) throws SQLException {
        if( val.length != paramCount )
            return false;

        List< String[] > tmp = null;
        boolean ret = true;
        synchronized( this ) {
            values.add( val );
            if( values.size() == batchCount ) {
                tmp = values;
                values = new LinkedList< String[] >();
            }
        }
        if( tmp != null ) {
            ret = RepoManager.getBiRepo().batchUpdate( batchSql, tmp );
        }
        return ret;
    }

    public boolean end() throws SQLException {
        List< String[] > tmp = null;
        synchronized( this ) {
            tmp = values;
            values = new LinkedList< String[] >();
        }
        if( tmp != null ) {
            for( String[] x : tmp ) {
                RepoManager.getBiRepo().update( sql, x );
            }
        }
        return true;
    }
}
