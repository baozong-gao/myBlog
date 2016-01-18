package com.gbz.myblog.bean.Enum;

public enum RespCodeEnum {

	S("00","交易成功"),
	F("01","交易失败"),
	E("99","系统错误");
	
	private String key;
	private String message;
	private RespCodeEnum(String key,String message){
		this.key = key;
		this.message = message;
	}
	public boolean equals(String key){
		return 	this.key.equalsIgnoreCase(key);
	}
	public String toKeyString(){
		return this.key;
	}
	public String toErrorMessage(){
		return this.message;
	}
}
