package com.xueJL.UtilsTool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class renewdatabase {
  public static void tryrenew() {
    if (dbifexits.adminexist() && dbifexits.userexist()) {
      System.out.println("检测到已有数据库表");
      System.out.println("初始化自动退出");
    } else {
      System.out.println("未检测到数据库表");
      System.out.println("准备开始初始化");
      renew();
    }
  }

  public static void renew() {
    System.out.println("开始尝试初始化数据库");
    Connection conn;
    Statement stmt;
    try {
      conn = JdbcProUtils.jdbcConnection();
      stmt = conn.createStatement();
      conn.setAutoCommit(false);
      stmt.addBatch(
          "create table if not exists admin_user\n"
              + "(\n"
              + "    id          int(10)      not null\n"
              + "        primary key,\n"
              + "    user_name   varchar(255) not null,\n"
              + "    user_passwd varchar(255) not null\n"
              + ");\n");
      stmt.addBatch(
          "create table usr_data_location\n"
              + "(\n"
              + "    user_id     int(254) auto_increment\n"
              + "        primary key,\n"
              + "    user_name   varchar(100)                  null,\n"
              + "    user_email  varchar(400)                  null,\n"
              + "    user_phone  varchar(400)                  null,\n"
              + "    user_passwd varchar(400) default '123456' not null,\n"
              + "    usr_balance int          default 0        not null,\n"
              + "    create_time varchar(100)                  null,\n"
              + "    constraint usr_data_location_user_name_uindex\n"
              + "        unique (user_name)\n"
              + ")\n"
              + "    comment '外部添加用户表' auto_increment = 4;\n"
              + "\n");
      stmt.addBatch(
          "INSERT INTO admin_user (id, user_name, user_passwd)\n"
              + "VALUES (1, 'admin', 'admin');");
      stmt.addBatch(
          "INSERT INTO admin_user (id, user_name, user_passwd)\n"
              + "VALUES (2, 'xueJL', '12210717');");
      stmt.addBatch(
          "INSERT INTO dbtest.usr_data_location (user_id, user_name, user_email, user_phone, user_passwd, usr_balance, create_time)\n"
              + "VALUES (1, 'xueJL', 'xueJLcat@outlook.com', '17735447050', '12210717', 500, '2022-05-03 11:45:23');");
      stmt.addBatch(
          "INSERT INTO dbtest.usr_data_location (user_id, user_name, user_email, user_phone, user_passwd, usr_balance, create_time)\n"
              + "VALUES (2, 'hzd', 'xueJL@shizuku.cc', '17635022071', '12210717', 1000, '2022-05-03 11:47:01');");
      int[] counts = stmt.executeBatch(); // 执行Batch中的全部语句
      conn.commit(); // 提交到数据库
      for (int i : counts) {
        if (i == 0) {
          conn.rollback();
        }
      }
      conn.setAutoCommit(true); // 在完成批量操作后恢复默认的自动提交方式，提高程序的可扩展性
      stmt.close();
      conn.close();
      System.out.println("数据库初始化成功");
      System.out.println("默认管理员账号：admin");
      System.out.println("默认管理员密码：admin");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
