package com.gbz.myblog.service;

import com.gbz.myblog.bean.view.PayRequestParams;
import com.gbz.myblog.bean.view.PayResposeRarams;
import com.gbz.myblog.bean.view.QueryRequestParams;
import com.gbz.myblog.bean.view.QueryResponseParams;

public interface TransService {
	
	/**
	 * 支付交易
	 */
	public PayResposeRarams doPay(PayRequestParams param);
	
	
	/**
	 * 查询交易
	 */
	public QueryResponseParams doQuery(QueryRequestParams param);
}
