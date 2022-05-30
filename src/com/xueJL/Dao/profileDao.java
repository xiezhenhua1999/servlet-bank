package com.xueJL.Dao;

import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class profileDao {
  //  public static void main(String[] args) {
  //    //
  //    String id = "5666";
  //
  //    System.out.println(idreturnprofile(id));
  //  }

  public static List<ProfileBean> idreturnprofile(String getid) {
    List<ProfileBean> usrlist = new ArrayList<>();
    Connection connection = null;
    PreparedStatement ment = null;
    ResultSet rs = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql = "select * from usr_data_location where user_id =?";
      ment = connection.prepareStatement(sql);
      ment.setString(1, getid);
      rs = ment.executeQuery();
      rs.next();
      ProfileBean usrData = new ProfileBean();
      usrData.setUserid(String.valueOf(rs.getInt("user_id")));
      usrData.setUsername(rs.getString("user_name"));
      usrData.setUseremail(rs.getString("user_email"));
      usrData.setUserphone(rs.getString("user_phone"));
      usrData.setUserpassword(rs.getString("user_passwd"));
      usrData.setUserbalance(rs.getString("usr_balance"));
      usrData.setCreatetime(rs.getString("create_time"));
      usrlist.add(usrData);
    } catch (SQLException ignored) {
    } finally {
      assert rs != null;
      JdbcProUtils.close(rs, connection, ment);
    }
    return usrlist;
  }
}
