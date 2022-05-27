package com.xueJL.BankModule;

import com.xueJL.JudeMthod.namexsitsjudge;
import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class checkblance {
  public static void getblance(Scanner input, String selfusrname) {
    Connection connection2 = null;
    PreparedStatement ment2 = null;
    ResultSet rs2 = null;
    while (true) {
      if (!namexsitsjudge.jude(selfusrname)) {
        System.out.println("输入的用户名" + selfusrname + "不存在");
        System.out.println("请重新输入要查询的用户名");
        selfusrname = input.next();
      } else {
        break;
      }
    }
    try {
      connection2 = JdbcProUtils.jdbcConnection();
      String sql = "SELECT  usr_balance from usr_data_location  where user_name = ?";
      ment2 = connection2.prepareStatement(sql);
      ment2.setString(1, selfusrname);
      rs2 = ment2.executeQuery();
      rs2.next();
      int selfgetbalance = rs2.getInt("usr_balance");
      System.out.println("当前的余额为" + selfgetbalance);
    } catch (SQLException ignored) {
    } finally {
      assert rs2 != null;
      JdbcProUtils.close(rs2, connection2, ment2);
    }
  }
}
