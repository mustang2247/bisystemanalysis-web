package com.bitop.web.bisystemanalysisweb.interfaces;

import java.sql.SQLException;

/**
 * Created by hoolai on 2016/7/22.
 */
public interface DataPackager< T > {
    T pack(String stmt) throws SQLException;
}
