package com.xueJL.BankModule;

import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class reducemoney {
  public static void reduce(int reducequery, String targetchangeuser) {
    // 减少存款方法
    int targetbalance = 0;
    Connection connection1 = null;
    PreparedStatement ment1 = null;
    ResultSet rs1 = null;
    try {
      connection1 = JdbcProUtils.jdbcConnection();
      String sql = "SELECT  usr_balance from usr_data_location  where user_name = ?";
      ment1 = connection1.prepareStatement(sql);
      ment1.setString(1, targetchangeuser);
      rs1 = ment1.executeQuery();
      rs1.next();
      targetbalance = rs1.getInt("usr_balance");
    } catch (SQLException ignored) {
    } finally {
      assert rs1 != null;
      JdbcProUtils.close(rs1, connection1, ment1);
    }
    if (targetbalance < reducequery) {
      System.out.println("余额不足,请充值后重试");
    } else {
      int afterreducequery = targetbalance - reducequery;
      Connection connection2 = null;
      PreparedStatement ment2 = null;
      try {
        connection2 = JdbcProUtils.jdbcConnection();
        String sql = "UPDATE usr_data_location SET usr_balance = ? WHERE user_name = ?";
        ment2 = connection2.prepareStatement(sql);
        ment2.setString(1, String.valueOf(afterreducequery));
        ment2.setString(2, targetchangeuser);
        ment2.executeUpdate();
      } catch (SQLException ignored) {
      } finally {
        assert connection2 != null;
        JdbcProUtils.closenors(connection2, ment2);
      }
    }
  }

  public static boolean reducetors(int reducequery, String targetchangeuser) {
    // 减少存款方法
    int targetbalance = 0;
    Connection connection1 = null;
    PreparedStatement ment1 = null;
    ResultSet rs1 = null;
    try {
      connection1 = JdbcProUtils.jdbcConnection();
      String sql = "SELECT  usr_balance from usr_data_location  where user_name = ?";
      ment1 = connection1.prepareStatement(sql);
      ment1.setString(1, targetchangeuser);
      rs1 = ment1.executeQuery();
      rs1.next();
      targetbalance = rs1.getInt("usr_balance");
    } catch (SQLException ignored) {
    } finally {
      assert rs1 != null;
      JdbcProUtils.close(rs1, connection1, ment1);
    }
    if (targetbalance < reducequery) {
      return false;
    } else {
      int afterreducequery = targetbalance - reducequery;
      Connection connection2 = null;
      PreparedStatement ment2 = null;
      try {
        connection2 = JdbcProUtils.jdbcConnection();
        String sql = "UPDATE usr_data_location SET usr_balance = ? WHERE user_name = ?";
        ment2 = connection2.prepareStatement(sql);
        ment2.setString(1, String.valueOf(afterreducequery));
        ment2.setString(2, targetchangeuser);
        ment2.executeUpdate();
        return true;
      } catch (SQLException ignored) {
      } finally {
        assert connection2 != null;
        JdbcProUtils.closenors(connection2, ment2);
      }
    }
    return false;
  }
}
