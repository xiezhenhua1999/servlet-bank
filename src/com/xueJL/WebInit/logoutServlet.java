package com.xueJL.WebInit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class logoutServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.removeAttribute("LoginUser");
    session.removeAttribute("LoginSuperUser");
    session.removeAttribute("selectuserdata");
    session.removeAttribute("LoginUsertempusername");
    session.removeAttribute("LoginUsertempuserpassword");
    resp.sendRedirect("/index.jsp");
  }
}
