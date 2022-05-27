package com.xueJL.FilterInit;

import com.xueJL.UtilsTool.dbintolist;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter("/admin/bank/*")
public class adminFilter implements javax.servlet.Filter {
  @Override
  public void destroy() {}

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    servletRequest.setCharacterEncoding("utf-8");
    HttpServletRequest HttpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse HttpServletResponse = (HttpServletResponse) servletResponse;
    List usrlist = dbintolist.getmenuList();
    HttpSession session = HttpServletRequest.getSession();
    session.setAttribute("allist", usrlist);
    //    System.out.println(session.getAttribute("allist"));
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
