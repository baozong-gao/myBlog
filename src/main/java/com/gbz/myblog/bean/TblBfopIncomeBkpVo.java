package com.gbz.myblog.bean;

public class TblBfopIncomeBkpVo {
	private String merId; //商户号
	private String merDate; //商户交易日期
	private String merCertNo; //商户证件号
	private String orderId; //交易订单号
	private String orderAmt; //交易金额
	private String cardNo; //消费卡号
	private String phone; //持卡人手机号
	private String custName; //持卡人名
	private String bankName; //发卡行
	private String bankRefNo; //银行流水号（参考号）
	private String autcod; //授权号
	private String cseqno; //凭证号
	private String payret; //银行返回码
	private String outcomeIdFk; //结算表外键
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getMerDate() {
		return merDate;
	}
	public void setMerDate(String merDate) {
		this.merDate = merDate;
	}
	public String getMerCertNo() {
		return merCertNo;
	}
	public void setMerCertNo(String merCertNo) {
		this.merCertNo = merCertNo;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(String orderAmt) {
		this.orderAmt = orderAmt;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankRefNo() {
		return bankRefNo;
	}
	public void setBankRefNo(String bankRefNo) {
		this.bankRefNo = bankRefNo;
	}
	public String getAutcod() {
		return autcod;
	}
	public void setAutcod(String autcod) {
		this.autcod = autcod;
	}
	public String getCseqno() {
		return cseqno;
	}
	public void setCseqno(String cseqno) {
		this.cseqno = cseqno;
	}
	public String getPayret() {
		return payret;
	}
	public void setPayret(String payret) {
		this.payret = payret;
	}
	public String getOutcomeIdFk() {
		return outcomeIdFk;
	}
	public void setOutcomeIdFk(String outcomeIdFk) {
		this.outcomeIdFk = outcomeIdFk;
	}
}
