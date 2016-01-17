package com.gbz.myblog.bean.view;

import com.gbz.myblog.bean.LineNumberVo;

public class PayRequestParams {

	private String merId;   //商户编号
	private String tranDate;   //交易日期
	private String tranTime;   //交易时间
	private String tranId;   //交易流水号
	private String currency;   //交易币种
	private String payAmt;   //交易金额
	private String payAcct;   //交易帐号
	private String orderId;   //代付订单号
	private String sendDate;   //代付请求日期
	private String sendTime;   //代付请求时间
	private String accNo;   //收款人账户号
	private String accName;   //收款人账户名
	private String branchId;   //收款人账户联行号
	private String transAmt;   //交易金额
	private String remark;   //客户流水摘要
	
	private LineNumberVo lineNumber;  //联行号
	
	
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
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public String getTranTime() {
		return tranTime;
	}
	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	public String getTranId() {
		return tranId;
	}
	public void setTranId(String tranId) {
		this.tranId = tranId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPayAmt() {
		return payAmt;
	}
	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}
	public String getPayAcct() {
		return payAcct;
	}
	public void setPayAcct(String payAcct) {
		this.payAcct = payAcct;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
