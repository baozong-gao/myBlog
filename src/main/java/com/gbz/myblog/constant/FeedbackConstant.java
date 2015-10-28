package com.gbz.myblog.constant;

/**
 * 用于系统向用户反馈信息
 * 
 * @author Administrator
 *
 */
public enum FeedbackConstant {
	
	userNotFind {
		public String key() {
			return "userNotFind";
		}
		public String message() {
			return "不存在此用户";
		}
	};
	public abstract String key();
	public abstract String message();

}
