package com.gbz.myblog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gbz.myblog.bean.User;
import com.gbz.myblog.bean.view.UserVo;
import com.gbz.myblog.constant.FeedbackConstant;
import com.gbz.myblog.constant.SystemConstant;
import com.gbz.myblog.service.UserService;

/**
 * 用户处理类 分担登入登出功能
 * 
 * @author Administrator
 *
 */
@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo uservo,
			HttpServletRequest request, HttpServletResponse response) {

		String userName = uservo.getUser_id();
		String passwd = uservo.getPasswd();
		logger.info("login user [{}] ", userName);
		User user = userService.getUserByNameAndPass(userName, passwd);
		if (user == null) {
			logger.info("login error: not user [{}]", userName);
			request.setAttribute(FeedbackConstant.userNotFind.key(),
					FeedbackConstant.userNotFind.message());
			return "login";
		}

		HttpSession session = request.getSession();
		session.setAttribute(SystemConstant.SESSION_KEY, user);

		return "";
	}

	@RequestMapping("/logout")
	public String logOut(HttpServletRequest request,
			HttpServletResponse response) {

		return "";
	}

}
