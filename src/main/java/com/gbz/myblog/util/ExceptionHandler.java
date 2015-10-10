package com.gbz.myblog.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 总异常处理类 处理所有spring管理的运行时异常
 * 
 * @author Administrator
 *
 */

@Component
public class ExceptionHandler implements HandlerExceptionResolver {
	private static final Logger logger = LoggerFactory
			.getLogger(ExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		logger.error("出错了", ex);

		request.setAttribute("exStackTrace", getExceptionStackTraceMessage(ex));
		if (ex instanceof ArithmeticException) {
			return new ModelAndView("error");
		}

		return null;
	}

	private String getExceptionStackTraceMessage(Exception ex) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		ex.printStackTrace(printWriter);
		return result.toString();
	}
	
}
