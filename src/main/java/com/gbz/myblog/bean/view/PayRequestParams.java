package com.gbz.myblog.bean.view;

import com.gbz.myblog.bean.LineNumberVo;

public class PayRequestParams {

	private String merId; // 商户编号
	private String merDate; // 商户日期
	private String merCertNo; // 商户证件号
	private String orderId; // 交易时间
	private String orderAmt; // 交易流水号
	private String payAcctNo; // 交易币种
	private String phone; // 手机号
	private String payAcctName; // 持卡人姓名
	private String payBankName; // 持卡人银行名称
	private String bankRefNo; // 银行流水号
	private String authCode; // 认证码
	private String certiCode; // 授权码
	private String payReturn; // 银行返回码
	private String clearingOrderId; // 代付订单号
	private String sendDate; // 代付请求日期
	private String sendTime; // 代付请求时间
	private String accNo; // 收款人账户号
	private String accName; // 收款人账户名
	private String branchId; // 收款人账户联行号
	private String transAmt; // 交易金额
	private String remark; // 客户流水摘要
	
	private LineNumberVo lineNumber;

	
	

	public LineNumberVo getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(LineNumberVo lineNumber) {
		this.lineNumber = lineNumber;
	}

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

	public String getPayAcctNo() {
		return payAcctNo;
	}

	public void setPayAcctNo(String payAcctNo) {
		this.payAcctNo = payAcctNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPayAcctName() {
		return payAcctName;
	}

	public void setPayAcctName(String payAcctName) {
		this.payAcctName = payAcctName;
	}

	public String getPayBankName() {
		return payBankName;
	}

	public void setPayBankName(String payBankName) {
		this.payBankName = payBankName;
	}

	public String getBankRefNo() {
		return bankRefNo;
	}

	public void setBankRefNo(String bankRefNo) {
		this.bankRefNo = bankRefNo;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getCertiCode() {
		return certiCode;
	}

	public void setCertiCode(String certiCode) {
		this.certiCode = certiCode;
	}

	public String getPayReturn() {
		return payReturn;
	}

	public void setPayReturn(String payReturn) {
		this.payReturn = payReturn;
	}

	public String getClearingOrderId() {
		return clearingOrderId;
	}

	public void setClearingOrderId(String clearingOrderId) {
		this.clearingOrderId = clearingOrderId;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
