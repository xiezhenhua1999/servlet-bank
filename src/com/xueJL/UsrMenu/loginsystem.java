package com.xueJL.UsrMenu;

import com.xueJL.Dao.usrDao;
import com.xueJL.JudeMthod.adminjudge;

import java.util.Scanner;

public class loginsystem {
  static int maxErrorTimes = 3;
  static int currentErrorTimes = 1;

  public static void adminlogin(Scanner input) {
    currentErrorTimes = 1;
    while (true) {
      System.out.println("请输入管理员账号");
      String inputAccount = input.next();
      System.out.println("请输入管理员密码");
      String inputPwd = input.next();
      boolean loginstatus = adminjudge.jude(inputPwd, inputAccount);
      if (loginstatus) {
        System.out.println("管理员登陆成功");
        System.out.println("欢迎管理员:" + inputAccount);
        adminchoselist.choose(input, inputAccount);
      } else if (currentErrorTimes > maxErrorTimes) {
        System.out.println("您累计输入错误" + currentErrorTimes + "次");
        System.out.println("已达最大输入错误次数");
        System.out.println("系统自动退出...");
        break;
      } else {
        System.out.println("当前输入错误次数" + currentErrorTimes + "次");
        currentErrorTimes++;
        System.out.println("用户名或密码错误");
      }
    }
  }

  public static void usrlogin(Scanner input) {
    currentErrorTimes = 1;
    while (true) {
      System.out.println("请输入用户账号");
      String inputAccount = input.next();
      System.out.println("请输入用户密码");
      String inputPwd = input.next();
      boolean loginstatus = usrDao.jude(inputPwd, inputAccount);
      if (loginstatus) {
        System.out.println("用户登陆成功");
        System.out.println("欢迎用户:" + inputAccount);
        usrchoselist.choose(input, inputAccount);
      } else if (currentErrorTimes > maxErrorTimes) {
        System.out.println("您累计输入错误" + currentErrorTimes + "次");
        System.out.println("已达最大输入错误次数");
        System.out.println("系统自动退出...");
        break;
      } else {
        System.out.println("当前输入错误次数" + currentErrorTimes + "次");
        currentErrorTimes++;
        System.out.println("用户名或密码错误");
      }
    }
  }
}
