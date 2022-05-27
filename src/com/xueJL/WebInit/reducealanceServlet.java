package com.xueJL.WebInit;

import com.xueJL.BankModule.reducemoney;
import com.xueJL.JudeMthod.idexsitsjudge;
import com.xueJL.JudeMthod.namexsitsjudge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/reducebalance")
public class reducealanceServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String userid = req.getParameter("reduceuserid");
    //    System.out.println(userid);
    String username = req.getParameter("reduceusername");
    //    System.out.println(username);
    int reducequary = Integer.parseInt(req.getParameter("reducequery"));
    //    System.out.println(reducequary);
    if (namexsitsjudge.jude(username) && idexsitsjudge.jude(userid)) {
      boolean flag = reducemoney.reducetors(reducequary, username);
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
    }
  }
}
