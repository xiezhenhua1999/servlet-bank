package com.xueJL.BankModule;

import java.util.Scanner;

public class banksuperlist {
  public static void adminlist(Scanner input) {
    while (true) {
      System.out.println("请输入'1-5'选择功能");
      System.out.println("1--查看用户余额");
      System.out.println("2--增加用户余额");
      System.out.println("3--减少用户余额");
      System.out.println("4--在用户间转账");
      System.out.println("0--返回管理员菜单");
      String usrChoosed = input.next();
      if ("1".equals(usrChoosed)) {
        System.out.println("请输入目标用户的用户名：");
        String inputAccount = input.next();
        checkblance.getblance(input, inputAccount);
        continue;
      }
      if ("2".equals(usrChoosed)) {
        System.out.println("请输入目标用户的用户名：");
        String inputAccount = input.next();
        System.out.println("请输入要增加的金额：");
        int inputmoney = Integer.parseInt(input.next());
        addmoney.addin(inputmoney, inputAccount);
        System.out.println("增加成功");
        continue;
      }
      if ("3".equals(usrChoosed)) {
        System.out.println("请输入目标用户的用户名：");
        String inputAccount = input.next();
        System.out.println("请输入要减少的金额：");
        int inputmoney = Integer.parseInt(input.next());
        reducemoney.reduce(inputmoney, inputAccount);
        System.out.println("余额减少成功");
        continue;
      }
      if ("4".equals(usrChoosed)) {
        System.out.println("请输入转出用户的用户名：");
        String inputtrancetargetoutname = input.next();
        System.out.println("请输入转入用户的用户名：");
        String inputtrancetargetinname = input.next();
        System.out.println("请输入转账金额：");
        int inputmoney = Integer.parseInt(input.next());
        trancemoney.tarnce(input, inputtrancetargetoutname, inputtrancetargetinname, inputmoney);
        continue;
      }
      if ("0".equals(usrChoosed)) {
        break;
      }
    }
  }
}
