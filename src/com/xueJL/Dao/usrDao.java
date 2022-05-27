package com.xueJL.Dao;

import com.xueJL.Entity.UserBean;
import com.xueJL.SonMethod.usetimeadd;
import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class usrDao {
  public static boolean jude(String inputPwd, String inputAccount) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql = "select * from  usr_data_location  where user_name = ? and user_passwd = ? ";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, inputAccount);
      preparedStatement.setString(2, inputPwd);
      rs = preparedStatement.executeQuery();
      if (rs.next()) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        JdbcProUtils.close(rs, connection, preparedStatement);
      }
    }
    return false;
  }

  public static boolean registerUser(UserBean userBeanreg) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql =
          "INSERT INTO usr_data_location (user_id, user_name, user_email, user_phone, user_passwd) VALUES (?, ?, ?, ?, ?);";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, userBeanreg.getUsrId());
      preparedStatement.setString(2, userBeanreg.getUsrName());
      preparedStatement.setString(3, userBeanreg.getUsrEmail());
      preparedStatement.setString(4, userBeanreg.getUsrPhone());
      preparedStatement.setString(5, userBeanreg.getUsrPassword());
      preparedStatement.executeUpdate();
      usetimeadd.timeadd(userBeanreg.getUsrName());
      //      System.out.println("新增用户成功");
      return true;
    } catch (SQLException ignored) {
    } finally {
      assert connection != null;
      JdbcProUtils.closenors(connection, preparedStatement);
    }
    return false;
  }

  public UserBean returnuserdata(String inputAccount, String inputPwd) {
    //    System.out.println(inputAccount);
    //    System.out.println(inputPwd);
    UserBean usrData = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs1 = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql = "select * from  usr_data_location  where user_name = ? and user_passwd = ? ";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, inputAccount);
      preparedStatement.setString(2, inputPwd);
      rs1 = preparedStatement.executeQuery();
      if (rs1.next()) {
        usrData = new UserBean();
        int userId = rs1.getInt("user_id");
        String userEmail = rs1.getString("user_email");
        String userPhone = rs1.getString("user_phone");
        String userBalance = rs1.getString("usr_balance");
        usrData.setUsrId(userId);
        usrData.setUsrName(inputAccount);
        usrData.setUsrEmail(userEmail);
        usrData.setUsrPhone(userPhone);
        usrData.setUsrPassword(inputPwd);
        usrData.setUsrBalance(userBalance);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usrData;
  }
}
