package com.xueJL.MainMethod;

import com.xueJL.Entity.UserBean;
import com.xueJL.SonMethod.namereturndata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class namesearchdata {
  public static void searchd(Scanner input) {
    List<UserBean> usrlist = new ArrayList<>();
    System.out.println("请输入要查找用户的用户名：");
    String readyToFoundUsrStr = input.next();
    usrlist = namereturndata.getdata(input, readyToFoundUsrStr, usrlist);
    System.out.println("您查询的用户信息为：");
    System.out.println(usrlist);
  }
}
