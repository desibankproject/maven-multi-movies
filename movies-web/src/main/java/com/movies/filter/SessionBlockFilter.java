package com.movies.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.model.Login;

/**
 * 
 * @author Nagendra
 *
 */
@WebFilter("/*")
public class SessionBlockFilter implements Filter {
	
	
	private List<String> allowsResources=new ArrayList<>();
	
	public void init(FilterConfig fConfig) throws ServletException {
		allowsResources.add("/oauth");
		allowsResources.add("/index.jsp");
		allowsResources.add("/cregister");
		allowsResources.add("/test.php");
		
		allowsResources.add("/moviesService");
		
		
	}
	


	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		String action=httpServletRequest.getServletPath();
		System.out.println("action = "+action);
		//go head.......
		if(allowsResources.contains(action) || action.contains("/img")) {
			chain.doFilter(request, response);
		}else{
			HttpSession session=httpServletRequest.getSession();
//			/	session.setAttribute("USER_SESSION_DATA", dlogin);
			Login sessionData=(Login)session.getAttribute("USER_SESSION_DATA");
			if(sessionData!=null && sessionData.getUsername()!=null) {
				chain.doFilter(request, response);
			}else{
				((HttpServletResponse)response).sendRedirect("oauth?message=Your session is timeout , please login again");
			}
		}
	}


}
