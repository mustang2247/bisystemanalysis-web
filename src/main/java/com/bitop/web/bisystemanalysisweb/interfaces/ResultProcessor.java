package com.bitop.web.bisystemanalysisweb.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hoolai on 2016/7/22.
 */

@FunctionalInterface
public interface ResultProcessor< T > {
    T process(ResultSet rs) throws SQLException;
}
