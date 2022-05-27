package com.xueJL.UtilsTool;

import java.sql.Connection;
import java.sql.Statement;

public class dbifexits {
  public static boolean adminexist() {
    Connection conn = null;
    Statement st = null;
    boolean flag = false;
    String sql = "SELECT COUNT(*) FROM admin_user";
    try {
      conn = JdbcProUtils.jdbcConnection();
      st = conn.createStatement();
      st.executeQuery(sql);
    } catch (Exception ignored) {
      // 该表不存在，则 会跳入catch中
      return false;
    }
    return true;
  }

  public static boolean userexist() {
    Connection conn = null;
    Statement st = null;
    boolean flag = false;
    String sql = "SELECT COUNT(*) FROM admin_user";
    try {
      conn = JdbcProUtils.jdbcConnection();
      st = conn.createStatement();
      st.executeQuery(sql);
    } catch (Exception ignored) {
      // 该表不存在，则 会跳入catch中
      return false;
    }
    return true;
  }
}
