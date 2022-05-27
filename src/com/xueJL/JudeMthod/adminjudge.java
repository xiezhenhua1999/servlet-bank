package com.xueJL.JudeMthod;

import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminjudge {
  public static boolean jude(String inputPwd, String inputAccount) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql = "select * from  admin_user  where user_name = ? and user_passwd = ? ";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, inputAccount);
      preparedStatement.setString(2, inputPwd);
      rs = preparedStatement.executeQuery();
      if (rs.next()) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        JdbcProUtils.close(rs, connection, preparedStatement);
      }
    }
    return false;
  }
}
