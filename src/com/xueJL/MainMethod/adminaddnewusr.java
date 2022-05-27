package com.xueJL.MainMethod;

import com.xueJL.SonMethod.addnewusr;

import java.util.Scanner;

public class adminaddnewusr {
  public static void addUsrData(Scanner inPut) {
    System.out.println("请输入要新增用户的id：");
    String readyToAddIdStr = inPut.next();
    addnewusr.adminadd(inPut, readyToAddIdStr);
  }
}
