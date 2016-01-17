package com.gbz.myblog.bean;

public class LineNumberVo {
	private String branchId; //联行号
	private String branchName; //联行名称
	private String bankProv; //银行所在省份
	private String bankCity; //银行所在城市
	private String bankDept; //银行所在支行
	private String bankResv; //联行信息备用域
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBankProv() {
		return bankProv;
	}
	public void setBankProv(String bankProv) {
		this.bankProv = bankProv;
	}
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	public String getBankDept() {
		return bankDept;
	}
	public void setBankDept(String bankDept) {
		this.bankDept = bankDept;
	}
	public String getBankResv() {
		return bankResv;
	}
	public void setBankResv(String bankResv) {
		this.bankResv = bankResv;
	}
}
