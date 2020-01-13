package com.fastech.view.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MyInterceptor implements HandlerInterceptor {
	private final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

	// 在请求处理之前进行调用（Controller方法调用之前
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {
		String requestUrl=httpServletRequest.getRequestURI();
		String url=httpServletRequest.getContextPath();
		String status = (String) httpServletRequest.getSession().getAttribute("isLogin");
		if (status == null || !status.equals("true")) {
			HttpServletResponse httpResponse = (HttpServletResponse) httpServletResponse;
			httpServletResponse.setCharacterEncoding("UTF-8");
			httpServletResponse.setContentType("application/json; charset=utf-8");
			PrintWriter out = null;
			JSONObject res = new JSONObject();
			res.put("code", -1);
			res.put("total", 0);
			res.put("rows", "");
			res.put("state", false);
			res.put("msg", "当前的Session已过期，请重新登陆");
			out = httpResponse.getWriter();
			out.append(res.toString());
			logger.info("当前的Session已过期，请重新登陆");
			return false;
		}
		return true;
	}
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
//		//    /EasyUI/userLogin.do
//		//String uri=request.getRequestURI();
//
//		//    http://localhost:8080/EasyUI/userLogin.do
//		String url=request.getRequestURL().toString();
//
//		System.out.println("当前访问地址："+url);
//
//		//登录页面不用检测，不然会出现Cannot forward after response has been committed（request多次提交）
////		if(url.indexOf("userLogin.do")>=0){
////			return true;
////		}
//		String status = (String) request.getSession().getAttribute("isLogin");
//		if (status == null || !status.equals("true")) {
//			toAlert(response);
//			return false;
//		}else{
//			return true;
//		}
//
//	}
	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {
//		System.out.println("postHandle被调用");
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {
//		System.out.println("afterCompletion被调用");
	}



	//前台弹出alert框
	public void toAlert( HttpServletResponse response){

		try {
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");

			OutputStreamWriter out=new OutputStreamWriter(response.getOutputStream());

			String msg="由于您长时间没有操作，session已过期，请重新登录！";
			msg=new String(msg.getBytes("UTF-8"));

			out.write("<meta http-equiv='Content-Type' content='text/html';charset='UTF-8'>");
			out.write("<script>");
			out.write("alert('"+msg+"');");
			out.write("top.location.href = '/blogdemo/login'; ");
			out.write("</script>");
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
