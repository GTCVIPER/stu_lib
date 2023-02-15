package com.gtc.utils;


import org.junit.Test;
import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();

    static {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            driver = bundle.getString("driver");
            url = bundle.getString("url");
            username = bundle.getString("jdbc.username");
            password = bundle.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        try {
            Connection conn = THREAD_LOCAL.get();
            if (conn == null) {
                Class.forName(driver);
                conn = DriverManager.getConnection(url,username,password);
                THREAD_LOCAL.set(conn);
            }
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void Begin(){
        Connection connection = getConnection();
        try {
            if (connection != null) {
                connection.setAutoCommit(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void Commit(){
        Connection connection = getConnection();
        try {
            if (connection != null) {
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection,null,null);
        }
    }
    public static void Rollback(){
        Connection connection = getConnection();
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection,null,null);
        }
    }

    public static void closeAll(Connection conn, ResultSet rs, Statement statement){
        if (conn != null) {
            try {
                conn.close();
                THREAD_LOCAL.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void testDB() {
        System.out.println(DBUtils.getConnection());
    }
}
