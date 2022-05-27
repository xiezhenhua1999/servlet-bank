package com.xueJL.MainMethod;

import com.xueJL.SonMethod.changedata;

import java.util.Scanner;

public class adminchangedata {
  public static void changeUsrData(Scanner inPut) {
    System.out.println("请输入要修改用户的id：");
    String readyToChangeIdStr = inPut.next();
    changedata.changed(inPut, readyToChangeIdStr);
  }
}
