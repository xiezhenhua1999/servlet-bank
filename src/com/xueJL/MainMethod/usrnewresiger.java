package com.xueJL.MainMethod;

import com.xueJL.SonMethod.usrregister;

import java.util.Scanner;

public class usrnewresiger {
  public static void addUsrData(Scanner inPut) {
    System.out.println("欢迎新用户注册：");
    System.out.println("请输入要注册的用户id：");
    String readyToAddIdStr = inPut.next();
    usrregister.resiger(inPut, readyToAddIdStr);
  }
}
