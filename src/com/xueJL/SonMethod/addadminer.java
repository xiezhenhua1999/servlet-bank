package com.xueJL.SonMethod;

import com.xueJL.JudeMthod.idexsitsjudge;
import com.xueJL.JudeMthod.namexsitsjudge;
import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class addadminer {
  public static void addadmin(Scanner inPut) {
    System.out.println("请输入新管理员的id：");
    String readyToAddIdStr = inPut.next();
    while (true) {
      if (idexsitsjudge.jude(readyToAddIdStr)) {
        System.out.println("输入的用户id已被占用");
        System.out.println("请重新输入用户新的id：");
        readyToAddIdStr = inPut.next();
      } else {
        break;
      }
    }
    System.out.println("请输入用户新的用户名：");
    String usrNewNameStr = inPut.next();
    while (true) {
      if (namexsitsjudge.jude(usrNewNameStr)) {
        System.out.println("输入的用户名已被占用");
        System.out.println("请重新输入用户新的用户名：");
        usrNewNameStr = inPut.next();
      } else {
        break;
      }
    }
    System.out.println("请输入用户新的密码：");
    String usrNewPasswdStr = inPut.next();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql = "INSERT INTO admin_user (id, user_name, user_passwd) VALUES (?, ?, ?);";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, readyToAddIdStr);
      preparedStatement.setString(2, usrNewNameStr);
      preparedStatement.setString(3, usrNewPasswdStr);
      preparedStatement.executeUpdate();
      System.out.println("新增管理员成功");
    } catch (SQLException ignored) {
    } finally {
      JdbcProUtils.closenors(connection, preparedStatement);
    }
  }
}
