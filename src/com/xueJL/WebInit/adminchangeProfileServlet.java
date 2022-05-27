package com.xueJL.WebInit;

import com.xueJL.Dao.profileDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/idgetmessagetochage")
public class adminchangeProfileServlet extends HttpServlet {
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
    profileDao profileDao = new profileDao();
    session.setAttribute("selectuserdata", com.xueJL.Dao.profileDao.idreturnprofile(id));
    //        System.out.println(session.getAttribute("selectuserdata"));
    resp.sendRedirect("/admin/bank/adminprofileedit.jsp");
  }
}
