package com.gbz.myblog.bean.view;

public class PayResposeRarams {

	private String respType;    //应答码类型
	private String respCode;    //应答码
	private String respMsg;    //应答描述
	private String sendDate;    //代付请求日期
	private String sendTime;    //代付请求时间
	private String tranId;    //全旗流水号
	private String bankTranId;    //宝付流水号
	private String bankReturnMsg;    //宝付应答信息
	private String bankTranDate;    //宝付交易日期
	public String getRespType() {
		return respType;
	}
	public void setRespType(String respType) {
		this.respType = respType;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
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
	public String getTranId() {
		return tranId;
	}
	public void setTranId(String tranId) {
		this.tranId = tranId;
	}
	public String getBankTranId() {
		return bankTranId;
	}
	public void setBankTranId(String bankTranId) {
		this.bankTranId = bankTranId;
	}
	public String getBankReturnMsg() {
		return bankReturnMsg;
	}
	public void setBankReturnMsg(String bankReturnMsg) {
		this.bankReturnMsg = bankReturnMsg;
	}
	public String getBankTranDate() {
		return bankTranDate;
	}
	public void setBankTranDate(String bankTranDate) {
		this.bankTranDate = bankTranDate;
	}
}
