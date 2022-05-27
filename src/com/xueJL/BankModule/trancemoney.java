package com.xueJL.BankModule;

import com.xueJL.JudeMthod.namexsitsjudge;
import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class trancemoney {
  public static void tarnce(
      Scanner input, String targettransferuser, String selfusrname, int trancemonenyquantity) {
    int selfgetbalance = 0;
    // 获取转账目标余额
    while (true) {
      if (!namexsitsjudge.jude(targettransferuser)) {
        System.out.println("输入的用户名" + targettransferuser + "不存在");
        System.out.println("请重新输入目标转账用户名");
        targettransferuser = input.next();
      } else {
        break;
      }
    }
    if (targettransferuser.equals(selfusrname)) {
      System.out.println("不可以向自己转账");
    } else {
      // 获取自身余额
      Connection connection2 = null;
      PreparedStatement ment2 = null;
      ResultSet rs2 = null;
      try {
        connection2 = JdbcProUtils.jdbcConnection();
        String sql = "SELECT  usr_balance from usr_data_location  where user_name = ?";
        ment2 = connection2.prepareStatement(sql);
        ment2.setString(1, selfusrname);
        rs2 = ment2.executeQuery();
        rs2.next();
        selfgetbalance = rs2.getInt("usr_balance");
        System.out.println("您当前的余额为" + selfgetbalance);
      } catch (SQLException ignored) {
      } finally {
        assert rs2 != null;
        JdbcProUtils.close(rs2, connection2, ment2);
      }
      if (selfgetbalance < trancemonenyquantity) {
        System.out.println("余额不足，请充值后再试");
      } else {
        System.out.println(
            "您(" + selfusrname + ")确定要转账" + trancemonenyquantity + "给" + targettransferuser + "吗");
        System.out.println("确认请输入'确认'");
        System.out.println("取消请输入'取消'");
        String usrChoosed = input.next();
        while (true) {
          if ("确认".equals(usrChoosed)) {
            reducemoney.reduce(trancemonenyquantity, selfusrname);
            addmoney.addin(trancemonenyquantity, targettransferuser);
            System.out.println("转账成功");
            break;
          }
          if ("取消".equals(usrChoosed)) {
            break;
          }
        }
      }
    }
  }

  public static boolean tarncewithout(
      String targettransferuser, String selfusrname, int trancemonenyquantity) {
    int selfgetbalance = 0;
    // 获取转账目标余额
    if (targettransferuser.equals(selfusrname)) {
      //      System.out.println("不可以向自己转账");
      return false;
    } else {
      // 获取自身余额
      Connection connection2 = null;
      PreparedStatement ment2 = null;
      ResultSet rs2 = null;
      try {
        connection2 = JdbcProUtils.jdbcConnection();
        String sql = "SELECT  usr_balance from usr_data_location  where user_name = ?";
        ment2 = connection2.prepareStatement(sql);
        ment2.setString(1, selfusrname);
        rs2 = ment2.executeQuery();
        rs2.next();
        selfgetbalance = rs2.getInt("usr_balance");
        //        System.out.println("您当前的余额为" + selfgetbalance);
      } catch (SQLException ignored) {
      } finally {
        assert rs2 != null;
        JdbcProUtils.close(rs2, connection2, ment2);
      }
      if (selfgetbalance < trancemonenyquantity) {
        //        System.out.println("余额不足，请充值后再试");
        return false;
      } else {
        reducemoney.reduce(trancemonenyquantity, selfusrname);
        addmoney.addin(trancemonenyquantity, targettransferuser);
        System.out.println("转账成功");
        return true;
      }
    }
  }
}
