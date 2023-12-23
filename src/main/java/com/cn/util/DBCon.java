package com.cn.util;
import java.sql.*;

import static java.lang.Class.forName;

public class DBCon {
    private static final String url= "jdbc:mysql://localhost:3306/student";
    private static final String user ="penghao712";
    private static final String password = "123456";

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getCon(){
        try{
            return DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void close(PreparedStatement prest, Connection con) {
        try {
            if (prest != null) {
                prest.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(ResultSet rs, PreparedStatement prest, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (prest != null) {
                prest.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
