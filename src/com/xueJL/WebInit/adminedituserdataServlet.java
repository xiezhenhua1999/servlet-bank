package com.xueJL.WebInit;

import com.xueJL.SonMethod.changedata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/adminedituserprofile")
public class adminedituserdataServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int targetuserid = Integer.parseInt(req.getParameter("targetuserid"));
    int targetnewuserid = Integer.parseInt(req.getParameter("targetnewuserid"));
    String targetnewusername = req.getParameter("targetnewusername");
    String targetnewuseremail = req.getParameter("targetnewuseremail");
    String targetnewuserphone = req.getParameter("targetnewuserphone");
    String targetnewuserpassword = req.getParameter("targetnewuserpassword");
    String targetnewuserbalance = req.getParameter("targetnewuserbalance");
    HttpSession session = req.getSession();

    if (session.getAttribute("LoginSuperUser") != null) {
      boolean flag =
          changedata.adminchangedata(
              targetuserid,
              targetnewuserid,
              targetnewusername,
              targetnewuseremail,
              targetnewuserphone,
              targetnewuserpassword,
              Integer.parseInt(targetnewuserbalance));
      if (flag) {
        session.removeAttribute("LoginUser");
        session.removeAttribute("selectuserdata");
        resp.sendRedirect("/infopage/adminsuccess.jsp");
      } else {
        resp.sendRedirect("/infopage/adminfailure.jsp");
      }
    } else {
      resp.sendRedirect("/infopage/adminfailure.jsp");
    }
  }
}
