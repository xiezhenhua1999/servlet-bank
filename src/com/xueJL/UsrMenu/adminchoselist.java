package com.xueJL.UsrMenu;

import com.xueJL.BankModule.banksuperlist;
import com.xueJL.MainMethod.*;
import com.xueJL.SonMethod.addadminer;
import com.xueJL.SonMethod.adminpwdchange;

import java.util.Scanner;

public class adminchoselist {
  public static void choose(Scanner input, String inputAccount) {
    while (true) {
      System.out.println("请输入'1-5'选择功能");
      System.out.println("1--通过用户id查询用户");
      System.out.println("2--通过用户名查询用户");
      System.out.println("3--新增用户");
      System.out.println("4--修改用户信息");
      System.out.println("5--删除用户");
      System.out.println("6--列出所有用户");
      System.out.println("7--添加管理员");
      System.out.println("8--修改管理员密码");
      System.out.println("9--银行系统超管");
      System.out.println("0--退出系统");
      String usrChoosed = input.next();
      if ("1".equals(usrChoosed)) {
        idsearchdata.searchd(input);
        continue;
      }
      if ("2".equals(usrChoosed)) {
        namesearchdata.searchd(input);
        continue;
      }
      if ("3".equals(usrChoosed)) {
        adminaddnewusr.addUsrData(input);
        continue;
      }
      if ("4".equals(usrChoosed)) {
        adminchangedata.changeUsrData(input);
        continue;
      }
      if ("5".equals(usrChoosed)) {
        admindelusrdata.delusr(input);
        continue;
      }
      if ("6".equals(usrChoosed)) {
        dropalldata.drop();
        continue;
      }
      if ("7".equals(usrChoosed)) {
        addadminer.addadmin(input);
        continue;
      }
      if ("8".equals(usrChoosed)) {
        adminpwdchange.change(input, inputAccount);
        continue;
      }
      if ("9".equals(usrChoosed)) {
        banksuperlist.adminlist(input);
        continue;
      }
      if ("0".equals(usrChoosed)) {
        System.out.println("退出中...");
        System.exit(0);
      }
    }
  }
}
