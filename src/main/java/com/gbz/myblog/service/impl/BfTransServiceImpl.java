package com.gbz.myblog.service.impl;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
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
import com.gbz.myblog.bean.Enum.RespCodeEnum;
import com.gbz.myblog.bean.Enum.TransStatusEnum;
import com.gbz.myblog.bean.view.PayRequestParams;
import com.gbz.myblog.bean.view.PayResposeRarams;
import com.gbz.myblog.bean.view.QueryRequestParams;
import com.gbz.myblog.bean.view.QueryResponseParams;
import com.gbz.myblog.service.TransService;
import com.gbz.myblog.util.BFConstants;
import com.gbz.myblog.util.DateUtil;
import com.gbz.myblog.util.JsonUtil;

@Service
public class BfTransServiceImpl implements TransService {

	private static final Logger logger = LoggerFactory
			.getLogger(BfTransServiceImpl.class);

	private static String dataType = "xml";
	
	private static final String CHARSET = "UTF-8";

	@Override
	public PayResposeRarams doPay(PayRequestParams param) {
		logger.info("支付请求参数：【{}】", JsonUtil.toJson(param));
		
		LineNumberVo lineNumber = param.getLineNumber();
		List trans_reqDatas = new ArrayList();
		TransReqBF0040001 transReqData = new TransReqBF0040001();
		transReqData.setTrans_no(param.getOrderId());
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
		
		Element messageElement = getMessageElement(reslut);
		String bankCode = getMessageFromElementTag(messageElement, "return_code");
		String bankMessage = getMessageFromElementTag(messageElement, "return_msg");
		String bankOrderid = getMessageFromElementTag(messageElement, "trans_orderid");
		String bankBatchid = getMessageFromElementTag(messageElement, "trans_batchid");
		String transNo = getMessageFromElementTag(messageElement, "trans_no");
		logger.info(String.format(
				"宝付代付网关,订单号：%s ,银行流水号：%s , 银行批次号：%s , 银行返回码：%s , 描述：%s .",
				transNo , bankOrderid , bankBatchid,bankCode, bankMessage));
		PayResposeRarams responseParam = new PayResposeRarams();
		
		if("0000".equals(bankCode)){
			responseParam.setRespType(TransStatusEnum.S.toString());
			responseParam.setRespCode(RespCodeEnum.S.toKeyString());
			responseParam.setRespMsg(RespCodeEnum.S.toErrorMessage());
		}else if("0300".equals(bankCode)||"0401".equals(bankCode)||"0999".equals(bankCode)){
			responseParam.setRespType(TransStatusEnum.I.toString());
		}else{
			responseParam.setRespType(TransStatusEnum.F.toString());
			responseParam.setRespCode(RespCodeEnum.F.toString());
			responseParam.setRespMsg(RespCodeEnum.F.toErrorMessage());
		}
		
		responseParam.setBankBatchid(bankBatchid);
		responseParam.setBankReturnCode(bankCode);
		responseParam.setBankReturnMsg(bankMessage);
		responseParam.setBankTranId(bankOrderid);
		responseParam.setBankTranDate(DateUtil.getCurrentDate());
		responseParam.setTranId(param.getOrderId());
		responseParam.setSendDate(DateUtil.getCurrentDate());
		responseParam.setSendTime(DateUtil.getCurrentTime());
		return responseParam;
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
		BfTransServiceImpl trans = new BfTransServiceImpl();
		QueryRequestParams param = new QueryRequestParams();
		param.setOrderId("24324");
		param.setRemark("asdf");
		trans.doQuery(param);
	}
	private  Element getMessageElement(String resultStr) {
		Document document = null;
		SAXReader saxReader = new SAXReader();
		try {
			document = saxReader.read(new ByteArrayInputStream(resultStr
					.getBytes(CHARSET)));
			Element rootElement = document.getRootElement();
			return rootElement;
		} catch (Exception e) {
			logger.error("XML解析错误", e);
		}
		logger.error("错误报文：【{}】", resultStr);
		return null;
	}
	private static String getMessageFromElementTag(Element e, String tag) {
		if (e == null) {
			return null;
		}
		String message = null;
		Element signNoNode = (Element) e.selectSingleNode("*/" + tag);
		if (signNoNode != null) {
			message = signNoNode.getTextTrim();
		}
		return message;
	}
}
