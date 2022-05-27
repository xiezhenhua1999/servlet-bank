package com.xueJL.SonMethod;

import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class usetimeadd {

  public static void timeadd(String username) {
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String nowStr = simpleDateFormat.format(date);
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql = "UPDATE usr_data_location SET create_time = ? WHERE user_name = ? ;";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, nowStr);
      preparedStatement.setString(2, username);
      preparedStatement.executeUpdate();
      //      System.out.println("时间更新成功");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      assert connection != null;
      JdbcProUtils.closenors(connection, preparedStatement);
    }
  }
}
