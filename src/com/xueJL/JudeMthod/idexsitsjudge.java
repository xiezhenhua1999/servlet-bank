package com.xueJL.JudeMthod;

import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class idexsitsjudge {
  public static boolean jude(String inputId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql = "select * from  usr_data_location where user_id = ?  ";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, inputId);
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
