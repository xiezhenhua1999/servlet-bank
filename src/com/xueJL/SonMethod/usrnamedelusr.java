package com.xueJL.SonMethod;

import com.xueJL.JudeMthod.idexsitsjudge;
import com.xueJL.JudeMthod.namexsitsjudge;
import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class usrnamedelusr {

  public static void delusr(String readyToDelNameStr) {
    if (namexsitsjudge.jude(readyToDelNameStr)) {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      System.out.println("正在删除用户信息...");
      try {
        connection = JdbcProUtils.jdbcConnection();
        String sql = "DELETE  FROM usr_data_location WHERE user_name = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, readyToDelNameStr);
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

  public static boolean iddelusr(String readyToDelid) {
    if (idexsitsjudge.jude(readyToDelid)) {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      //      System.out.println("正在删除id为" + readyToDelid + "的用户信息...");
      try {
        connection = JdbcProUtils.jdbcConnection();
        String sql = "DELETE  FROM usr_data_location WHERE user_id= ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, readyToDelid);
        preparedStatement.executeUpdate();
      } catch (SQLException ignored) {
      } finally {
        assert connection != null;
        JdbcProUtils.closenors(connection, preparedStatement);
      }
      return true;
    } else {
      return false;
    }
  }
}
