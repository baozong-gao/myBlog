package com.gbz.myblog.bean.Enum;

public enum TransStatusEnum {

	S("S","交易成功"),
	F("F","交易失败"),
	I("I","交易初始"),
	E("E","系统错误");
	
	private String key;
	private String message;
	private TransStatusEnum(String key,String message){
		this.key = key;
		this.message = message;
	}
	public boolean equals(String key){
		return 	this.key.equalsIgnoreCase(key);
	}
}
