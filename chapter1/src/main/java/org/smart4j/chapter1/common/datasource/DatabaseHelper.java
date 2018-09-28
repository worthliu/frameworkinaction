package org.smart4j.chapter1.common.datasource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter1.common.utils.PropsUtils;
import org.smart4j.chapter1.service.CommonService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName DatabaseHelper
 * @Description 数据库操作类
 * @Author Administrator
 * @Date 2018/9/28 22:28
 * @Version 1.0
 */
public class DatabaseHelper {
    private static final Logger logger = LoggerFactory.getLogger(CommonService.class);
    /**
     * 数据库链接持有对象
     */
    private static final ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<>();
    //
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    static {
        Properties conf = PropsUtils.loadProps("config.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");

        try {
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            logger.error("can not load jdbc driver", e);
            System.exit(1);
        }
    }

    /**
     * @return
     */
    public static Connection getConnection(){
        Connection conn = CONNECTION_HOLDER.get();
        if(conn == null){
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                logger.error("building JDBC connection failure", e);
            }finally {
                CONNECTION_HOLDER.set(conn);
            }
        }
        return conn;
    }

    /**
     * @param conn
     */
    public static void closeConnection(Connection conn){
        if (conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                logger.error("close connection failure", e);
            }
        }
    }

    public static <T> List<T> queryEntiryList(Class<T> entityClass, String sql, Object... params){
        List<T> entityList;
        Connection conn = getConnection();
        try{
            entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<T>(entityClass), params);
        }catch (SQLException e) {
            logger.error("query entity list failure", e);
            throw new RuntimeException(e);
        }finally {
            closeConnection(conn);
        }
        return entityList;
    }


}
