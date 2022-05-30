package com.xueJL.Dao;

import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class menuDao {
  public static List getList() {
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
        MenuBean menuData = new MenuBean();
        menuData.setUserId(rs.getInt("user_id"));
        menuData.setUserName(rs.getString("user_name"));
        menuData.setUserBalance(rs.getInt("usr_balance"));
        menuData.setCreateTime(rs.getString("create_time"));
        usrlist.add(menuData);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      assert rs != null;
      JdbcProUtils.close(rs, connection, ment);
    }
    return usrlist;
  }

  public List<MenuBean> listForUser(Integer userId) {
    List<MenuBean> list = new ArrayList<>();
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "select * from usr_data_location where user_id = ? ";
    try {
      assert con != null;
      preparedStatement = con.prepareStatement(sql);
      // 设置占位符
      preparedStatement.setInt(1, userId);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        MenuBean menuBean = new MenuBean();
        menuBean.setUserId(resultSet.getInt("user_id"));
        menuBean.setUserName(resultSet.getString("user_name"));
        menuBean.setUserBalance(resultSet.getInt("usr_balance"));
        menuBean.setCreateTime(resultSet.getString("create_time"));
        list.add(menuBean);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  //    public boolean upMenuById(MenuBean menuBean) {
  //        con = getCon();
  //        String sql = "update  menu  set title = ?, content = ? where id = ?";
  //        int i = 0;
  //        try {
  //            preparedStatement = con.prepareStatement(sql);
  //            //设置占位符
  //            preparedStatement.setString(1, menuBean.getTitle());
  //            preparedStatement.setString(2, menuBean.getContent());
  //            preparedStatement.setInt(3, menuBean.getId());
  //            i = preparedStatement.executeUpdate();
  //        } catch (SQLException e) {
  //            e.printStackTrace();
  //        }
  //        if (i > 0) {
  //            return true;
  //        }
  //        return false;
  //    }

  public boolean delMenuById(int menuId) {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    String sql = "delete  from  usr_data_location where user_id =?";
    int i = 0;
    try {
      con = JdbcProUtils.jdbcConnection();
      preparedStatement = con.prepareStatement(sql);
      // 设置占位符
      preparedStatement.setInt(1, menuId);
      i = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return i > 0;
  }

  public boolean delMenuByName(String inmenuusername) {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    String sql = "delete  from  usr_data_location where user_name =?";
    int i = 0;
    try {
      con = JdbcProUtils.jdbcConnection();
      preparedStatement = con.prepareStatement(sql);
      // 设置占位符
      preparedStatement.setString(1, inmenuusername);
      i = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return i > 0;
  }
}
