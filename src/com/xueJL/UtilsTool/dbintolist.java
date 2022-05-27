package com.xueJL.UtilsTool;

import com.xueJL.Entity.MenuBean;
import com.xueJL.Entity.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dbintolist {

  public static List getList() {
    List<UserBean> usrlist = new ArrayList<>();
    Connection connection = null;
    PreparedStatement ment = null;
    ResultSet rs = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql = "select * from usr_data_location ";
      ment = connection.prepareStatement(sql);
      rs = ment.executeQuery(sql);
      while (rs.next()) {
        UserBean usrData = new UserBean();
        usrData.setUsrId(rs.getInt("user_id"));
        usrData.setUsrName(rs.getString("user_name"));
        usrData.setUsrEmail(rs.getString("user_email"));
        usrData.setUsrPhone(rs.getString("user_phone"));
        usrData.setUsrBalance(rs.getString("usr_balance"));
        usrlist.add(usrData);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      assert rs != null;
      JdbcProUtils.close(rs, connection, ment);
    }

    return usrlist;
  }

  public static List getmenuList() {
    List<MenuBean> usrlist = new ArrayList<>();
    Connection connection = null;
    PreparedStatement ment = null;
    ResultSet rs = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql = "select * from usr_data_location ";
      ment = connection.prepareStatement(sql);
      rs = ment.executeQuery(sql);
      while (rs.next()) {
        MenuBean usrData = new MenuBean();
        usrData.setUserId(rs.getInt("user_id"));
        usrData.setUserName(rs.getString("user_name"));
        usrData.setUserBalance(Integer.valueOf(rs.getString("usr_balance")));
        usrData.setCreateTime(rs.getString("create_time"));

        usrlist.add(usrData);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      assert rs != null;
      JdbcProUtils.close(rs, connection, ment);
    }

    return usrlist;
  }
}
