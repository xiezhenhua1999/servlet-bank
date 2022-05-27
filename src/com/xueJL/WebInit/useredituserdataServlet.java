package com.xueJL.WebInit;

import com.xueJL.SonMethod.changedata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/useredituserprofile")
public class useredituserdataServlet extends HttpServlet {
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
    HttpSession session = req.getSession();
    String tempusername = (String) session.getAttribute("LoginUsertempusername");
    String tempuserpassword = (String) session.getAttribute("LoginUsertempuserpassword");

    if (session.getAttribute("LoginUser") != null) {
      boolean flag =
          changedata.userchangedata(
              targetuserid,
              targetnewuserid,
              targetnewusername,
              targetnewuseremail,
              targetnewuserphone,
              targetnewuserpassword);
      if (flag) {
        if (targetnewusername.equals(tempusername)
            && targetnewuserpassword.equals(tempuserpassword)) {
          resp.sendRedirect("/infopage/usersuccess.jsp");
        } else {
          session.removeAttribute("LoginUser");
          session.removeAttribute("selectuserdata");
          resp.sendRedirect("/infopage/usersuccess.jsp");
        }
      } else {
        resp.sendRedirect("/infopage/userfailure.jsp");
      }
    } else {
      resp.sendRedirect("/infopage/userfailure.jsp");
    }
  }
}
