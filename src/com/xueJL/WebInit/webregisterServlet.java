package com.xueJL.WebInit;

import com.xueJL.Dao.usrDao;
import com.xueJL.Entity.UserBean;
import com.xueJL.JudeMthod.idexsitsjudge;
import com.xueJL.JudeMthod.namexsitsjudge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/webregister")
public class webregisterServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    //        req.setCharacterEncoding("utf-8");
    String regid = req.getParameter("regid");
    String regname = req.getParameter("regname");
    String regpassword = req.getParameter("regpassword");
    String regemail = req.getParameter("regemail");
    String regphone = req.getParameter("regphone");
    HttpSession session = req.getSession();
    //    System.out.println(regid + regname + regemail + regpassword + regphone);
    if (namexsitsjudge.jude(regid) && idexsitsjudge.jude(regname)) {
      resp.sendRedirect("/infopage/failure.jsp");
    } else {
      UserBean userBeanreg = new UserBean();
      userBeanreg.setUsrId(Integer.parseInt(regid));
      userBeanreg.setUsrName(regname);
      userBeanreg.setUsrPassword(regpassword);
      userBeanreg.setUsrPhone(regphone);
      userBeanreg.setUsrEmail(regemail);
      boolean flag = usrDao.registerUser(userBeanreg);
      //        System.out.println(flag);
      if (flag) {
        if (session.getAttribute("LoginSuperUser") != null) {
          resp.sendRedirect("/infopage/adminsuccess.jsp");
        } else {
          resp.sendRedirect("/infopage/regsuccess.jsp");
        }
      } else {
        if (session.getAttribute("LoginSuperUser") != null) {
          resp.sendRedirect("/infopage/adminfailure.jsp");
        } else {
          resp.sendRedirect("/infopage/failure.jsp");
        }
      }
    }
  }
}
