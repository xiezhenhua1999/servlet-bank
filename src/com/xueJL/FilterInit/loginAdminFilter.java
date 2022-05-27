package com.xueJL.FilterInit;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/bank/*")
public class loginAdminFilter implements Filter {
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
    String adminer = (String) session.getAttribute("LoginSuperUser");
    if (adminer != null) {
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      HttpServletResponse.sendRedirect("/admin/index.jsp");
    }
  }
}
