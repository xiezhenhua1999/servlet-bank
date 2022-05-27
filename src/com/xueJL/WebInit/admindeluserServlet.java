package com.xueJL.WebInit;

import com.xueJL.JudeMthod.idexsitsjudge;
import com.xueJL.SonMethod.usrnamedelusr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/iddeluser")
public class admindeluserServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String id = req.getParameter("id");
    System.out.println(id);
    if (idexsitsjudge.jude(id)) {
      boolean flag = usrnamedelusr.iddelusr(id);
      if (flag) {
        session.removeAttribute("LoginUser");
        session.removeAttribute("LoginUsertempusername");
        session.removeAttribute("LoginUsertempuserpassword");
        resp.sendRedirect("/admin/bank/adminpanel.jsp");
      } else {
        resp.sendRedirect("/infopage/failure.jsp");
      }
    } else {
      resp.sendRedirect("/infopage/failure.jsp");
    }
  }
}
