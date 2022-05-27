package com.xueJL.UtilsTool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcProUtils {

  public static Connection jdbcConnection() throws SQLException {
    Properties properties = new Properties();
    InputStream configStream =
        JdbcProUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
    try {
      properties.load(configStream);
    } catch (IOException ignored) {
    }
    String dbDriver = properties.getProperty("jdbc.driver");
    String dbUrl = properties.getProperty("jdbc.url");
    String dbUser = properties.getProperty("jdbc.user");
    String dbPasswd = properties.getProperty("jdbc.passwd");
    try {
      if (configStream != null) {
        configStream.close();
      }
    } catch (IOException ignored) {
    }
    try {
      Class.forName(dbDriver);
    } catch (ClassNotFoundException ignored) {
    }
    return DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
  }

  public static void close(
      ResultSet rs, Connection connection, PreparedStatement preparedStatement) {
    try {
      rs.close();
    } catch (SQLException ignored) {
    }
    try {
      connection.close();
    } catch (SQLException ignored) {
    }
    try {
      preparedStatement.close();
    } catch (SQLException ignored) {
    }
  }

  public static void closenors(Connection connection, PreparedStatement preparedStatement) {
    try {
      connection.close();
    } catch (SQLException ignored) {
    }
    try {
      preparedStatement.close();
    } catch (SQLException ignored) {
    }
  }
}
