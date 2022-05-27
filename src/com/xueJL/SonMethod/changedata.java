package com.xueJL.SonMethod;

import com.xueJL.JudeMthod.idexsitsjudge;
import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class changedata {
  public static void changed(Scanner inPut, String readyToChangeIdStr) {
    if (!idexsitsjudge.jude(readyToChangeIdStr)) {
      System.out.println("修改失败：未找id为" + readyToChangeIdStr + "的用户");
    } else {
      System.out.println("请输入用户新的id：");
      String usrNewIdStr = inPut.next();
      while (true) {
        boolean newinputid = idexsitsjudge.jude(usrNewIdStr);
        if (newinputid == true) {
          System.out.println("输入的用户id已被占用");
          System.out.println("请重新输入用户新的id：");
          String reUsrNewIdStr = inPut.next();
          usrNewIdStr = reUsrNewIdStr;
        } else {
          break;
        }
      }
      System.out.println("请输入用户新的姓名：");
      String usrNewNameStr = inPut.next();
      System.out.println("请输入用户新的电话：");
      String usrNewPhoneStr = inPut.next();
      System.out.println("请输入用户新的邮箱：");
      String usrNewEmailStr = inPut.next();
      System.out.println("请输入用户新的密码：");
      String usrNewPasswdStr = inPut.next();
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      ResultSet rs = null;
      try {
        connection = JdbcProUtils.jdbcConnection();
        String sql =
            "UPDATE usr_data_location SET user_id = ?, user_name  = ?, user_email  = ?, user_phone  = ?, user_passwd = ? WHERE user_id = ?; ";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, usrNewIdStr);
        preparedStatement.setString(2, usrNewNameStr);
        preparedStatement.setString(3, usrNewEmailStr);
        preparedStatement.setString(4, usrNewPhoneStr);
        preparedStatement.setString(5, usrNewPasswdStr);
        preparedStatement.setString(6, readyToChangeIdStr);
        preparedStatement.executeUpdate();
        System.out.println("修改用户信息成功");
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        assert connection != null;
        JdbcProUtils.closenors(connection, preparedStatement);
      }
    }
  }

  public static boolean userchangedata(
      int readyToChangeIdInt,
      int usrNewIdInt,
      String usrNewNameStr,
      String usrNewEmailStr,
      String usrNewPhoneStr,
      String usrNewPasswdStr) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql =
          "UPDATE usr_data_location SET user_id = ?, user_name  = ?, user_email  = ?, user_phone  = ?, user_passwd = ? WHERE user_id = ?; ";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, usrNewIdInt);
      preparedStatement.setString(2, usrNewNameStr);
      preparedStatement.setString(3, usrNewEmailStr);
      preparedStatement.setString(4, usrNewPhoneStr);
      preparedStatement.setString(5, usrNewPasswdStr);
      preparedStatement.setInt(6, readyToChangeIdInt);
      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      assert connection != null;
      JdbcProUtils.closenors(connection, preparedStatement);
    }
    return false;
  }

  public static boolean adminchangedata(
      int readyToChangeIdInt,
      int usrNewIdInt,
      String usrNewNameStr,
      String usrNewEmailStr,
      String usrNewPhoneStr,
      String usrNewPasswdStr,
      int usrNewBalanceInt) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql =
          "UPDATE usr_data_location SET user_id = ?, user_name  = ?, user_email  = ?, user_phone  = ?, user_passwd = ? , usr_balance = ?  WHERE user_id = ?; ";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, usrNewIdInt);
      preparedStatement.setString(2, usrNewNameStr);
      preparedStatement.setString(3, usrNewEmailStr);
      preparedStatement.setString(4, usrNewPhoneStr);
      preparedStatement.setString(5, usrNewPasswdStr);
      preparedStatement.setInt(6, usrNewBalanceInt);
      preparedStatement.setInt(7, readyToChangeIdInt);
      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      assert connection != null;
      JdbcProUtils.closenors(connection, preparedStatement);
    }
    return false;
  }
}
