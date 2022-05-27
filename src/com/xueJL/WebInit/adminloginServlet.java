package com.xueJL.WebInit;

import com.xueJL.JudeMthod.adminjudge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/adminlogin")
public class adminloginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    //        super.doPost(req, resp);
    //        req.setCharacterEncoding("utf-8");
    String userName = req.getParameter("username");
    String password = req.getParameter("password");
    //        System.out.println("username:"+userName);
    //        System.out.println("password:"+password);
    boolean flag = adminjudge.jude(password, userName);
    //        System.out.println(flag);
    if (flag) {
      HttpSession session = req.getSession();
      session.removeAttribute("LoginUser");
      session.setAttribute("LoginSuperUser", userName);
      //            System.out.println(session.getAttribute("LoginSuperUser"));
      resp.sendRedirect("/admin/bank/adminpanel.jsp");
    }else {
      resp.sendRedirect("/infopage/adminfailure.jsp");
    }
  }
}
