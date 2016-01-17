package com.gbz.myblog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baofoo.sdk.demo.base.TransContent;
import com.baofoo.sdk.demo.base.request.TransReqBF0040001;
import com.baofoo.sdk.demo.base.request.TransReqBF0040002;
import com.baofoo.sdk.domain.RequestParams;
import com.baofoo.sdk.http.SimpleHttpResponse;
import com.baofoo.sdk.rsa.RsaCodingUtil;
import com.baofoo.sdk.util.BaofooClient;
import com.gbz.myblog.bean.LineNumberVo;
import com.gbz.myblog.bean.view.PayRequestParams;
import com.gbz.myblog.bean.view.PayResposeRarams;
import com.gbz.myblog.bean.view.QueryRequestParams;
import com.gbz.myblog.bean.view.QueryResponseParams;
import com.gbz.myblog.service.TransService;
import com.gbz.myblog.util.BFConstants;
import com.gbz.myblog.util.JsonUtil;

@Service
public class TransServiceImpl implements TransService {

	private static final Logger logger = LoggerFactory
			.getLogger(TransServiceImpl.class);

	private static String dataType = "xml";

	@Override
	public PayResposeRarams doPay(PayRequestParams param) {
		logger.info("支付请求参数：【{}】", JsonUtil.toJson(param));
		
		LineNumberVo lineNumber = param.getLineNumber();
		List trans_reqDatas = new ArrayList();
		TransReqBF0040001 transReqData = new TransReqBF0040001();
		transReqData.setTrans_no(param.getTranId());
		transReqData.setTrans_money(param.getTransAmt());
		transReqData.setTo_acc_name(param.getAccName());
		transReqData.setTo_acc_no(param.getAccNo());
		transReqData.setTo_bank_name(lineNumber.getBranchName());
		transReqData.setTo_pro_name(lineNumber.getBankProv());
		transReqData.setTo_city_name(lineNumber.getBankCity());
		transReqData.setTo_acc_dept(lineNumber.getBankDept());
		transReqData.setTrans_summary("备注1");
		trans_reqDatas.add(transReqData);

		TransContent transContent = new TransContent(dataType);
		transContent.setTrans_reqDatas(trans_reqDatas);
		String bean2XmlString = transContent.obj2Str(transContent);
		logger.info("报文：【{}】", bean2XmlString);

		String keyStorePath = BFConstants.KEYSTORE_PATH;
		String keyStorePassword = BFConstants.KEYSTORE_PASSWORD;
		String pub_key = BFConstants.PUB_KEY;
		String origData = bean2XmlString;
		origData = new String(Base64.encodeBase64(origData.getBytes()));
		String encryptData = RsaCodingUtil.encryptByPriPfxFile(origData,
				keyStorePath, keyStorePassword);
		logger.info("----------->【私钥加密-结果】" + encryptData);

		String requestUrl = BFConstants.PAY_URL;
		String memberId = BFConstants.MEMBER_ID;
		String terminalId = BFConstants.TERMINAL_ID;
		RequestParams params = new RequestParams();
		params.setMemberId(Integer.parseInt(memberId));
		params.setTerminalId(Integer.parseInt(terminalId));
		params.setDataType(dataType);
		params.setDataContent(encryptData);
		params.setVersion("4.0.0");
		params.setRequestUrl(requestUrl);
		String reslut = null;
		try {
			SimpleHttpResponse response = BaofooClient.doRequest(params);
			reslut = response.getEntityString();
			reslut = new String(new Base64().decode(reslut));
			logger.info("宝付请求返回结果：【{}】",reslut);
		} catch (Exception e) {
			logger.error("解析银行报文错误",e);
		}
		
		if(reslut != null){
			
		}
		
		return null;
	}

	@Override
	public QueryResponseParams doQuery(QueryRequestParams param) {
		logger.info("查询交易报文：【{}】", JsonUtil.toJson(param));
		TransContent transContent = new TransContent(dataType);

		List<TransReqBF0040002> trans_reqDatas = new ArrayList<TransReqBF0040002>();
		TransReqBF0040002 transReqData = new TransReqBF0040002();
		transReqData.setTrans_batchid(param.getRemark());
		transReqData.setTrans_no(param.getOrderId());
		trans_reqDatas.add(transReqData);

		transContent.setTrans_reqDatas(trans_reqDatas);

		String bean2XmlString = transContent.obj2Str(transContent);
		System.out.println("报文：" + bean2XmlString);

		String keyStorePath = BFConstants.KEYSTORE_PATH;
		String keyStorePassword = BFConstants.KEYSTORE_PASSWORD;
		String pub_key = BFConstants.PUB_KEY;
		String origData = bean2XmlString;

		origData = new String(Base64.encodeBase64(origData.getBytes()));
		String encryptData = RsaCodingUtil.encryptByPriPfxFile(origData,
				keyStorePath, keyStorePassword);

		System.out.println("----------->【私钥加密-结果】" + encryptData);

		String requestUrl = BFConstants.QUERY_URL;
		String memberId = BFConstants.MEMBER_ID;
		String terminalId = BFConstants.TERMINAL_ID;

		RequestParams params = new RequestParams();
		params.setMemberId(Integer.parseInt(memberId));
		params.setTerminalId(Integer.parseInt(terminalId));
		params.setDataType(dataType);
		params.setDataContent(encryptData);
		params.setVersion("4.0.0");
		params.setRequestUrl(requestUrl);
		String reslut = null;
		try {
			SimpleHttpResponse response = BaofooClient.doRequest(params);
			reslut = response.getEntityString();
			reslut = RsaCodingUtil.decryptByPubCerFile(reslut, pub_key);
			reslut = new String(new Base64().decode(reslut));
			logger.info("宝付请求返回结果：【{}】" ,reslut);
		} catch (Exception e) {
			logger.error("解析银行返回出错",e);
		}

		System.out.println(reslut);
		return null;
	}
	
	public static void main(String[] args) {
		TransServiceImpl trans = new TransServiceImpl();
		QueryRequestParams param = new QueryRequestParams();
		param.setOrderId("24324");
		param.setRemark("asdf");
		trans.doQuery(param);
	}
}
