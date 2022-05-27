package com.xueJL.UsrMenu;

import com.xueJL.MainMethod.usrnewresiger;

import java.util.Scanner;

public class allenterinit {
  public static void enterd() {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.println("请输入'1-5'选择功能");
      System.out.println("1--用户登录");
      System.out.println("2--用户注册");
      System.out.println("3--管理员登录");
      //      System.out.println("4--初始化数据库");
      System.out.println("0--退出系统");
      String usrChoosed = input.next();
      if ("1".equals(usrChoosed)) {
        loginsystem.usrlogin(input);
        continue;
      }
      if ("2".equals(usrChoosed)) {
        usrnewresiger.addUsrData(input);
        continue;
      }
      if ("3".equals(usrChoosed)) {
        loginsystem.adminlogin(input);
        continue;
      }
      //      if ("4".equals(usrChoosed)) {
      //        renewdatabase.tryrenew();
      //      }
      if ("0".equals(usrChoosed)) {
        System.exit(0);
      }
    }
  }
}
