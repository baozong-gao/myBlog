package com.gbz.myblog.util;


import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.gbz.myblog.bean.User;
import com.gbz.myblog.constant.SystemConstant;


public class UrlFilter implements Filter {
	Logger logger = Logger.getLogger(UrlFilter.class);
	private FilterConfig config = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest hr = (HttpServletRequest) request;
		HttpSession session = hr.getSession();
		User user = (User) session.getAttribute(SystemConstant.SESSION_KEY);
		if (hr.getRequestURI().contains("resources")) {
			String uri = hr.getRequestURI();
			String ch = URLDecoder.decode(uri, "UTF-8");
			if (uri.equals(ch)) {
				chain.doFilter(request, response);
			} else {
				ch = ch.substring(hr.getContextPath().length());
				config.getServletContext().getRequestDispatcher(ch).forward(request, response);
			}
		} else if (hr.getServletPath().equals("/login") || hr.getServletPath().equals("/")) {
			chain.doFilter(request, response);
		} else if (user != null && user.getUserName()!=null) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/login").forward(request, response);
		}
	}

	@Override
	public void destroy() {

	}

}
