package com.xueJL.MainMethod;

import com.xueJL.UtilsTool.dbintolist;

import java.util.List;

public class dropalldata {
  public static void drop() {
    System.out.println("正在处理...");
    List usrlist = dbintolist.getList();
    System.out.println(usrlist);
  }
}
