package com.xueJL.SonMethod;

import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class adminpwdchange {
  public static void change(Scanner input, String inputAccount) {
    System.out.println("请输入管理员" + inputAccount + "的新密码：");
    String adminNewPasswdStr = input.next();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql = "UPDATE admin_user SET user_passwd = ? WHERE user_name = ?; ";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, adminNewPasswdStr);
      preparedStatement.setString(2, inputAccount);
      preparedStatement.executeUpdate();
      System.out.println("修改管理员密码成功");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      assert connection != null;
      JdbcProUtils.closenors(connection, preparedStatement);
    }
  }
}
