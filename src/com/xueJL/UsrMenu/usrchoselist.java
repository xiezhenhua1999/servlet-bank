package com.xueJL.UsrMenu;

import com.xueJL.BankModule.addmoney;
import com.xueJL.BankModule.checkblance;
import com.xueJL.BankModule.reducemoney;
import com.xueJL.BankModule.trancemoney;
import com.xueJL.Entity.UserBean;
import com.xueJL.MainMethod.usrdelself;
import com.xueJL.SonMethod.namechangedata;
import com.xueJL.SonMethod.namereturndata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class usrchoselist {
  public static void choose(Scanner input, String inputAccount) {
    while (true) {
      System.out.println("请输入'1-5'选择功能");
      System.out.println("1--查看信息");
      System.out.println("2--更改信息");
      System.out.println("3--查看余额");
      System.out.println("4--存款");
      System.out.println("5--取款");
      System.out.println("6--转账");
      System.out.println("7--切换用户");
      System.out.println("8--注销用户");
      System.out.println("0--退出系统");
      String usrChoosed = input.next();
      if ("1".equals(usrChoosed)) {
        List<UserBean> usrlist = new ArrayList<>();
        usrlist = namereturndata.getdata(input, inputAccount, usrlist);
        System.out.println(usrlist);
        continue;
      }
      if ("2".equals(usrChoosed)) {
        namechangedata.changed(input, inputAccount);
        continue;
      }
      if ("3".equals(usrChoosed)) {
        checkblance.getblance(null, inputAccount);
        continue;
      }
      if ("4".equals(usrChoosed)) {
        System.out.println("请输入要存入的金额：");
        int inputmoney = Integer.parseInt(input.next());
        addmoney.addin(inputmoney, inputAccount);
        System.out.println("存入成功");
        continue;
      }
      if ("5".equals(usrChoosed)) {
        System.out.println("请输入要取出的金额：");
        int inputmoney = Integer.parseInt(input.next());
        reducemoney.reduce(inputmoney, inputAccount);
        System.out.println("取出成功");
        continue;
      }
      if ("6".equals(usrChoosed)) {
        System.out.println("请输入转账目标用户名：");
        String inputtrancetargetname = input.next();
        System.out.println("请输入转账金额：");
        int inputmoney = Integer.parseInt(input.next());
        trancemoney.tarnce(input, inputtrancetargetname, inputAccount, inputmoney);
        continue;
      }
      if ("7".equals(usrChoosed)) {
        break;
      }
      if ("8".equals(usrChoosed)) {
        usrdelself.delusr(input, inputAccount);
        continue;
      }
      if ("0".equals(usrChoosed)) {
        System.out.println("退出中...");
        System.exit(0);
      }
    }
  }
}
