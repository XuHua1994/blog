package com.fastech.view.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Order(1)
@WebFilter(filterName = "MSecurity", urlPatterns = { "*.ftl" })
public class MyFilter implements Filter {
	private final Logger logger = LoggerFactory.getLogger(MyFilter.class);
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println(request.getRequestURI());
        String url=request.getContextPath();
        String requestUrl=request.getRequestURI();
		// 检查是否是登录页面
//		if (requestUrl.equals(url+"/adminview/login")  || requestUrl.equals(url+"/adminview/register")
//				|| requestUrl.equals(url+"/adminview/loginout")) {
//			filterChain.doFilter(servletRequest, servletResponse);
//		} else {
			// 检测用户是否登录
		HttpSession session = request.getSession();
		String status = (String) session.getAttribute("isLogin");
		if (status == null || !status.equals("true")) {
			try {
				response.sendRedirect("/blogdemo/login");
				filterChain.doFilter(servletRequest, servletResponse);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
			
//		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}