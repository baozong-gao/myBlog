package com.gbz.myblog.bean;

public class TblBfopOutcomeRecordVo {
	private String outcomeId; // 结算流水号
	private String recvDate; // 接收请求日期
	private String recvTime; // 接收请求时间
	private String transAmt; // 结算金额
	private String transStatus;//结算状态 
	private String acctNo; // 卡号
	private String acctName; // 户名
	private String sendDate; // 发送请求日期
	private String sendTime; // 发送请求时间
	private String channelReturnCode; // 银行返回码
	private String channelReturnMsg; // 银行对应的返回
	private String channelReturnSeq1; // 银行返回流水号1
	private String channelReturnSeq2; // 银行返回流水号2
	private String channelCheckFlag; // 对账标志
	private String channelReturnDate; // 银行返回日期
	private String channelReturnTime; // 银行返回时间
	private String channelBatchId; // 银行返回批次号
	private String branchId; // 联行号

	public String getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}

	public String getOutcomeId() {
		return outcomeId;
	}

	public void setOutcomeId(String outcomeId) {
		this.outcomeId = outcomeId;
	}

	public String getRecvDate() {
		return recvDate;
	}

	public void setRecvDate(String recvDate) {
		this.recvDate = recvDate;
	}

	public String getRecvTime() {
		return recvTime;
	}

	public void setRecvTime(String recvTime) {
		this.recvTime = recvTime;
	}

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
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

	public String getChannelReturnCode() {
		return channelReturnCode;
	}

	public void setChannelReturnCode(String channelReturnCode) {
		this.channelReturnCode = channelReturnCode;
	}

	public String getChannelReturnMsg() {
		return channelReturnMsg;
	}

	public void setChannelReturnMsg(String channelReturnMsg) {
		this.channelReturnMsg = channelReturnMsg;
	}

	public String getChannelReturnSeq1() {
		return channelReturnSeq1;
	}

	public void setChannelReturnSeq1(String channelReturnSeq1) {
		this.channelReturnSeq1 = channelReturnSeq1;
	}

	public String getChannelReturnSeq2() {
		return channelReturnSeq2;
	}

	public void setChannelReturnSeq2(String channelReturnSeq2) {
		this.channelReturnSeq2 = channelReturnSeq2;
	}

	public String getChannelCheckFlag() {
		return channelCheckFlag;
	}

	public void setChannelCheckFlag(String channelCheckFlag) {
		this.channelCheckFlag = channelCheckFlag;
	}

	public String getChannelReturnDate() {
		return channelReturnDate;
	}

	public void setChannelReturnDate(String channelReturnDate) {
		this.channelReturnDate = channelReturnDate;
	}

	public String getChannelReturnTime() {
		return channelReturnTime;
	}

	public void setChannelReturnTime(String channelReturnTime) {
		this.channelReturnTime = channelReturnTime;
	}

	public String getChannelBatchId() {
		return channelBatchId;
	}

	public void setChannelBatchId(String channelBatchId) {
		this.channelBatchId = channelBatchId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

}
