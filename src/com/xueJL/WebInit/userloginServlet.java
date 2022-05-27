package com.xueJL.WebInit;

import com.xueJL.Dao.usrDao;
import com.xueJL.Entity.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/usrlogin")
public class userloginServlet extends HttpServlet {
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
    //    System.out.println("username:" + userName);
    //    System.out.println("password:" + password);
    boolean flag = usrDao.jude(password, userName);
    //    System.out.println(flag);
    if (flag) {
      usrDao userDao = new usrDao();
      UserBean userdata = userDao.returnuserdata(userName, password);
      //      System.out.println(userdata);
      HttpSession session = req.getSession();
      session.removeAttribute("LoginSuperUser");
      session.setAttribute("LoginUser", userdata);
      session.setAttribute("LoginUsertempusername", userName);
      session.setAttribute("LoginUsertempuserpassword", password);
      //      System.out.println(session.getAttribute("LoginUser"));
      resp.sendRedirect("/index.jsp");
    } else {
      resp.sendRedirect("/infopage/failure.jsp");
    }
  }
}
