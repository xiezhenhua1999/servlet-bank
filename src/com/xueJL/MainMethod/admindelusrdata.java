package com.xueJL.MainMethod;

import com.xueJL.SonMethod.delusrdata;

import java.util.Scanner;

public class admindelusrdata {
  public static void delusr(Scanner input) {
    System.out.println("请输入要删除用户的id");
    String readyToDelIdStr = input.next();
    delusrdata.delusr(readyToDelIdStr);
  }
}
