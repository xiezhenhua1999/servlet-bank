package com.xueJL.SonMethod;

import com.xueJL.JudeMthod.idexsitsjudge;
import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delusrdata {
  public static void delusr(String readyToDelIdStr) {
    if (idexsitsjudge.jude(readyToDelIdStr)) {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      System.out.println("正在删除用户信息...");
      try {
        connection = JdbcProUtils.jdbcConnection();
        String sql = "DELETE  FROM usr_data_location WHERE user_id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, readyToDelIdStr);
        preparedStatement.executeUpdate();
      } catch (SQLException ignored) {
      } finally {
        assert connection != null;
        JdbcProUtils.closenors(connection, preparedStatement);
      }
      System.out.println("删除成功");
    } else {
      System.out.println("该id下没有用户");
    }
  }
}
