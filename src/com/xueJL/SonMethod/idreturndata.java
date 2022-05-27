package com.xueJL.SonMethod;

import com.xueJL.Entity.UserBean;
import com.xueJL.JudeMthod.idexsitsjudge;
import com.xueJL.UtilsTool.JdbcProUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class idreturndata {
  public static List getdata(Scanner input, String readyToFoundUsrStr) {
    while (true) {
      if (idexsitsjudge.jude(readyToFoundUsrStr)) {
        break;
      } else {
        System.out.println("输入的用户id不存在");
        System.out.println("请输入用户新的id：");
        String usrNewIdStr = input.next();
        readyToFoundUsrStr = usrNewIdStr;
      }
    }
    List<UserBean> usrlist = new ArrayList<>();
    Connection connection = null;
    PreparedStatement ment = null;
    ResultSet rs = null;
    try {
      connection = JdbcProUtils.jdbcConnection();
      String sql = "select * from usr_data_location where user_id =?";
      ment = connection.prepareStatement(sql);
      ment.setString(1, readyToFoundUsrStr);
      rs = ment.executeQuery();
      rs.next();
      UserBean usrData = new UserBean();
      usrData.setUsrId(rs.getInt("user_id"));
      usrData.setUsrName(rs.getString("user_name"));
      usrData.setUsrEmail(rs.getString("user_email"));
      usrData.setUsrPhone(rs.getString("user_phone"));
      usrData.setUsrBalance(rs.getString("usr_balance"));
      usrlist.add(usrData);
    } catch (SQLException ignored) {
    } finally {
      assert rs != null;
      JdbcProUtils.close(rs, connection, ment);
    }
    return usrlist;
  }
}
