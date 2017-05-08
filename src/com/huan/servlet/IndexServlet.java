package com.huan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huan.user.User;


@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null){
			response.getWriter().append("<h2>µÇÂ¼Ê§°Ü£¬Çë<a href='/AProject/index.html'>µÇÂ¼</a></h2>");
			
		}else{
			response.getWriter().print("<h2>ÄúÒÑ¾­µÇÂ¼£ºÕË»§£º"+user.getUsername()+"</h2>");
			response.getWriter().append("<h2><a href='/AProject/logoutServlet'>ÍË³ö</a></h2>");
			Cookie cookie = new Cookie("JSESSIONID",session.getId());
			cookie.setMaxAge(60*30);
			cookie.setPath("/AProject");
			response.addCookie(cookie);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
