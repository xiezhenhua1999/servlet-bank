package com.xueJL.FilterInit;

import com.xueJL.Dao.usrDao;
import com.xueJL.Entity.UserBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/web/bank/*"})
public class loginUserFilter implements Filter {
  @Override
  public void destroy() {}

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest HttpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse HttpServletResponse = (HttpServletResponse) servletResponse;
    HttpSession session = HttpServletRequest.getSession();
    UserBean userBean = (UserBean) session.getAttribute("LoginUser");
    if (userBean != null) {
      String tempusername = (String) session.getAttribute("LoginUsertempusername");
      String tempuserpassword = (String) session.getAttribute("LoginUsertempuserpassword");
      session.removeAttribute("LoginUser");
      usrDao userDao = new usrDao();
      UserBean userdata = userDao.returnuserdata(tempusername, tempuserpassword);
      //      System.out.println(userdata);
      session.setAttribute("LoginUser", userdata);
      //      System.out.println(session.getAttribute("LoginUser"));
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      HttpServletResponse.sendRedirect("/index.jsp");
    }
  }
}
