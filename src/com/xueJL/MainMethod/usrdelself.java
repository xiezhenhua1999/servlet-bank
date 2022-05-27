package com.xueJL.MainMethod;

import com.xueJL.SonMethod.usrnamedelusr;

import java.util.Scanner;

public class usrdelself {
  public static void delusr(Scanner input, String inputAccount) {
    System.out.println("是否要注销并在数据库中删除自己的数据");
    System.out.println("继续注销请输入'确认',取消输入'取消'");
    String conferned = input.next();
    while (true) {
      if ("确认".equals(conferned)) {
        usrnamedelusr.delusr(inputAccount);
        System.out.println("注销成功，系统自动退出");
        System.exit(0);
      }
      if ("取消".equals(conferned)) {
        break;
      }
    }
  }
}
