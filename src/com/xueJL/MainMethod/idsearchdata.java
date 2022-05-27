package com.xueJL.MainMethod;

import com.xueJL.SonMethod.idreturndata;

import java.util.List;
import java.util.Scanner;

public class idsearchdata {
  public static void searchd(Scanner input) {
    List usrlist;
    System.out.println("请输入要查找用户的id：");
    String readyToFoundUsrStr = input.next();
    usrlist = idreturndata.getdata(input, readyToFoundUsrStr);
    System.out.println("您查询的用户信息为：");
    System.out.println(usrlist);
  }
}
