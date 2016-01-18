package com.gbz.myblog.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbz.myblog.bean.Enum.RespCodeEnum;
import com.gbz.myblog.bean.Enum.TransStatusEnum;
import com.gbz.myblog.bean.view.PayRequestParams;
import com.gbz.myblog.bean.view.PayResposeRarams;
import com.gbz.myblog.service.TransService;
import com.gbz.myblog.service.dao.TblBfopOutcomeRecordService;
import com.gbz.myblog.service.dao.impl.LineNumberServiceImpl;
import com.gbz.myblog.util.JsonUtil;
import com.gbz.myblog.util.SystemErrorException;

@Service
public class PayTransService {
	private static final Logger logger = LoggerFactory
			.getLogger(PayTransService.class);

	@Autowired
	LineNumberServiceImpl lineNumberServiceImpl;

	@Autowired
	TransService bfTransServiceImpl;

	@Autowired
	TblBfopOutcomeRecordService tblBfopOutcomeRecordServiceImpl;

	public PayResposeRarams doPay(PayRequestParams param){
		logger.info("支付请求参数：【{}】", JsonUtil.toJson(param));
		PayResposeRarams response = null;
		try {
			lineNumberServiceImpl.setLineNumberToPayVo(param);

			tblBfopOutcomeRecordServiceImpl.initTransRecord(param);

			response = bfTransServiceImpl.doPay(param);

			tblBfopOutcomeRecordServiceImpl.updateTransRecord(param, response);
		} catch (Exception e) {
			logger.error("交易失败", e);
			response = new PayResposeRarams();
			response.setRespCode(RespCodeEnum.E.toKeyString());
			response.setRespMsg(RespCodeEnum.E.toErrorMessage());
			response.setRespType(TransStatusEnum.E.toString());
		}
		return response;
	}
}
