package com.bitop.web.bisystemanalysisweb.model.logic.user;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger( UserService.class );

    private String sqlinsert = "insert into bi_user (deviceid,appID,userID,userOpenID,userName,userGold,userDiamond,userSex,userLevel,userExp,userIsRecharged,userVIPExp,createTime,updateTime,clientV) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private String sqlupdate = "update bi_user set userName=?, userGold=?, userDiamond=?, userSex=?, userLevel=?, userExp=?, userIsRecharged=?, userVIPExp=?, updateTime=?, clientV=? where deviceid=? and appID=? and userID=?";
    private String selectsql = "select * from bi_user where appID=? and userID=?";

    /**
     * 检查用户信息
     * @param data
     * @return
     * @throws SQLException
     */
    public boolean check(JSONObject data) throws SQLException {
        // 时间
//        LocalDateTime date = LocalDateTime.now();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        try {
//            String[] values;// = new String[]{"1156ac10200756c8","1", "110522", "xxxxx", "99990000", "12345", "1", "11", "11911", "false", "123445435", dateTimeFormatter.format(date)};
////        logger.info(sqlupdate);
//            int id = RepoManager.getUserSqlRepo().select(selectsql, new String[]{
//                    BiReportManager.safeString(data.getString("appID")),
//                    BiReportManager.safeString(data.getString("userID"))});
//            logger.info(id + "");
//            if(id > 0){
//                values = new String[]{
//                        BiReportManager.safeString(data.getString("deviceid")),
//                        BiReportManager.safeString(data.getString("appID")),
//                        BiReportManager.safeString(data.getString("userID")),
//                        BiReportManager.safeString(data.getString("userName")),
//
//                        BiReportManager.safeString(data.getString("userGold")),
//                        BiReportManager.safeString(data.getString("userDiamond")),
//                        BiReportManager.safeString(data.getString("userSex")),
//                        BiReportManager.safeString(data.getString("userLevel")),
//                        BiReportManager.safeString(data.getString("userExp")),
//                        BiReportManager.safeString(data.getString("userIsRecharged")),
//                        BiReportManager.safeString(data.getString("userVIPExp")),
//                        dateTimeFormatter.format(date),
//                        BiReportManager.safeString(data.getString("clientV"))
//                };
//
////            logger.info(Arrays.asList(values) + "");
//                return RepoManager.getUserSqlRepo().update(sqlupdate, values);
//            }else {
//                values = new String[]{
//                        BiReportManager.safeString(data.getString("deviceid")),
//                        BiReportManager.safeString(data.getString("appID")),
//                        BiReportManager.safeString(data.getString("userID")),
//                        BiReportManager.safeString(data.getString("userOpenID")),
//                        BiReportManager.safeString(data.getString("userName")),
//
//                        BiReportManager.safeString(data.getString("userGold")),
//                        BiReportManager.safeString(data.getString("userDiamond")),
//                        BiReportManager.safeString(data.getString("userSex")),
//                        BiReportManager.safeString(data.getString("userLevel")),
//                        BiReportManager.safeString(data.getString("userExp")),
//
//                        BiReportManager.safeString(data.getString("userIsRecharged")),
//                        BiReportManager.safeString(data.getString("userVIPExp")),
//
//                        dateTimeFormatter.format(date),
//                        dateTimeFormatter.format(date),
//                        BiReportManager.safeString(data.getString("clientV"))
//                };
//
////            logger.info(Arrays.asList(values) + "");
//                return RepoManager.getUserSqlRepo().insert(sqlinsert, values);
//            }
//        }catch (Exception e){
//            logger.info(e.getMessage());
//        }
//
        return false;
    }

}
