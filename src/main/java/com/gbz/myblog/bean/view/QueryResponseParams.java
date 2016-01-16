package com.gbz.myblog.bean.view;

public class QueryResponseParams {

	private String resp_type;  //应答码类型
	private String resp_code;  //应答码
	private String resp_msg;  //应答描述
	private String clearing_date;  //代付日期
	private String clearing_time;  //代付时间
	private String tran_id;  //全旗流水号
	private String bank_tran_id;  //宝付流水号
	private String bank_return_code;  //宝付应答码
	private String bank_return_msg;  //宝付应答信息
	public String getResp_type() {
		return resp_type;
	}
	public void setResp_type(String resp_type) {
		this.resp_type = resp_type;
	}
	public String getResp_code() {
		return resp_code;
	}
	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}
	public String getResp_msg() {
		return resp_msg;
	}
	public void setResp_msg(String resp_msg) {
		this.resp_msg = resp_msg;
	}
	public String getClearing_date() {
		return clearing_date;
	}
	public void setClearing_date(String clearing_date) {
		this.clearing_date = clearing_date;
	}
	public String getClearing_time() {
		return clearing_time;
	}
	public void setClearing_time(String clearing_time) {
		this.clearing_time = clearing_time;
	}
	public String getTran_id() {
		return tran_id;
	}
	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}
	public String getBank_tran_id() {
		return bank_tran_id;
	}
	public void setBank_tran_id(String bank_tran_id) {
		this.bank_tran_id = bank_tran_id;
	}
	public String getBank_return_code() {
		return bank_return_code;
	}
	public void setBank_return_code(String bank_return_code) {
		this.bank_return_code = bank_return_code;
	}
	public String getBank_return_msg() {
		return bank_return_msg;
	}
	public void setBank_return_msg(String bank_return_msg) {
		this.bank_return_msg = bank_return_msg;
	}
}
