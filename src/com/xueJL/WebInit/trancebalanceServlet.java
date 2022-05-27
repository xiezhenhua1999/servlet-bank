package com.xueJL.WebInit;

import com.xueJL.BankModule.trancemoney;
import com.xueJL.JudeMthod.namexsitsjudge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/trancebalance")
public class trancebalanceServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String outuser = req.getParameter("tranceoutuserid");
    //    System.out.println(outuser);
    String inuser = req.getParameter("tranceinusername");
    HttpSession session = req.getSession();
    //    System.out.println(inuser);
    int trancequary = Integer.parseInt(req.getParameter("trancequery"));
    //    System.out.println(trancequary);
    if (namexsitsjudge.jude(outuser) && namexsitsjudge.jude(inuser)) {
      boolean flag = trancemoney.tarncewithout(inuser, outuser, trancequary);
      //      System.out.println(flag);
      if (flag) {
        if (session.getAttribute("LoginUser") != null) {
          resp.sendRedirect("/infopage/usersuccess.jsp");
        } else {
          resp.sendRedirect("/infopage/adminsuccess.jsp");
        }
      } else if (session.getAttribute("LoginUser") != null) {
        resp.sendRedirect("/infopage/userfailure.jsp");
      } else {
        resp.sendRedirect("/infopage/adminfailure.jsp");
      }
    } else {
      if (session.getAttribute("LoginUser") != null) {
        resp.sendRedirect("/infopage/userfailure.jsp");
      } else {
        resp.sendRedirect("/infopage/adminfailure.jsp");
      }
    }
  }
}
