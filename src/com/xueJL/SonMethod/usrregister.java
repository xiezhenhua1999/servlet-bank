package com.xueJL.SonMethod;

import com.xueJL.JudeMthod.idexsitsjudge;
import com.xueJL.JudeMthod.namexsitsjudge;
import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class usrregister {
  public static void resiger(Scanner inPut, String readyToAddIdStr) {
    while (true) {
      if (idexsitsjudge.jude(readyToAddIdStr)) {
        System.out.println("输入的用户id已被占用");
        System.out.println("请重新输入用户新的id：");
        String reUsrNewIdStr = inPut.next();
        readyToAddIdStr = reUsrNewIdStr;
      } else {
        break;
      }
    }
    System.out.println("请输入用户新的姓名：");
    String usrNewNameStr = inPut.next();
    while (true) {
      if (namexsitsjudge.jude(usrNewNameStr)) {
        System.out.println("输入的用户名已被占用");
        System.out.println("请重新输入要注册的用户名：");
        String reUsrNewNameStr = inPut.next();
        usrNewNameStr = reUsrNewNameStr;
      } else {
        break;
      }
    }
    System.out.println("请输入要注册的用户的电话：");
    String usrNewPhoneStr = inPut.next();
    System.out.println("请输入要注册的用户的邮箱：");
    String usrNewEmailStr = inPut.next();
    System.out.println("请输入要注册的用户的密码：");
    String usrNewPasswdStr = inPut.next();
    // 新建对象，使用set方法替换旧的
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql =
          "INSERT INTO usr_data_location (user_id, user_name, user_email, user_phone, user_passwd) VALUES (?, ?, ?, ?, ?);";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, readyToAddIdStr);
      preparedStatement.setString(2, usrNewNameStr);
      preparedStatement.setString(3, usrNewEmailStr);
      preparedStatement.setString(4, usrNewPhoneStr);
      preparedStatement.setString(5, usrNewPasswdStr);
      preparedStatement.executeUpdate();
      System.out.println("新用户注册成功");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      assert connection != null;
      JdbcProUtils.closenors(connection, preparedStatement);
    }
  }
}
