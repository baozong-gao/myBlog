package com.gbz.myblog.bean.view;

public class QueryRequestParams {

	private String orderId; //代付订单号
	private String remark; //客户流水摘要
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
