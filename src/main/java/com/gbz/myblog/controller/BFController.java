package com.gbz.myblog.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gbz.myblog.bean.view.PayRequestParams;
import com.gbz.myblog.bean.view.PayResposeRarams;
import com.gbz.myblog.service.impl.PayTransService;
import com.gbz.myblog.util.BFConstants;
import com.gbz.myblog.util.JsonUtil;
import com.gbz.myblog.util.Money;
import com.gbz.myblog.util.Rsa;
import com.gbz.myblog.util.XmlUtil;

/**
 * 宝付交易接口
 * @author Administrator
 *
 */

@Controller
public class BFController {
	private Logger logger = LoggerFactory.getLogger(BFController.class);
	
	@Autowired
	PayTransService payTransService;
	
	@RequestMapping("/allcheer/outcome/pay")
	@ResponseBody
	public void payAccept(@RequestBody String data , HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		
		Rsa rsa = new Rsa();
		rsa.initKeyFromJks(BFConstants.OUTCOME_KEY_PATH, BFConstants.OUTCOME_KEY_PASSWD, BFConstants.OUTCOME_KEY_PRIVATE_ALIAS, BFConstants.OUTCOME_KEY_PUBLIC_ALIAS);
		byte[] nuSignMessage = rsa.nuSignByPrivateKey(data.getBytes("UTF-8"));
		data = new String(nuSignMessage,"UTF-8");
		String merId = XmlUtil.getTagValueFormHtml(data, "MER_ID");
		String merDate = XmlUtil.getTagValueFormHtml(data, "MER_DATE");
		String merCertNo = XmlUtil.getTagValueFormHtml(data, "MER_CERT_NO");
		String orderId = XmlUtil.getTagValueFormHtml(data, "ORDER_ID");
		String orderAmt = XmlUtil.getTagValueFormHtml(data, "ORDER_AMT");
		String payAcctNo = XmlUtil.getTagValueFormHtml(data, "PAY_ACCT_NO");
		String phone = XmlUtil.getTagValueFormHtml(data, "PHONE");
		String payAcctName = XmlUtil.getTagValueFormHtml(data, "PAY_ACCT_NAME");
		String payBankName = XmlUtil.getTagValueFormHtml(data, "PAY_BANK_NAME");
		String bankRefNo = XmlUtil.getTagValueFormHtml(data, "BANK_REF_NO");
		String authCode = XmlUtil.getTagValueFormHtml(data, "AUTH_CODE");
		String certiCode = XmlUtil.getTagValueFormHtml(data, "CERTI_CODE");
		String payReturn = XmlUtil.getTagValueFormHtml(data, "PAY_RETURN");
		String clearingOrderId = XmlUtil.getTagValueFormHtml(data, "CLEARING_ORDER_ID");
		String sendDate = XmlUtil.getTagValueFormHtml(data, "SEND_DATE");
		String sendTime = XmlUtil.getTagValueFormHtml(data, "SEND_TIME");
		String accNo = XmlUtil.getTagValueFormHtml(data, "ACC_NO");
		String accName = XmlUtil.getTagValueFormHtml(data, "ACC_NAME");
		String branchId = XmlUtil.getTagValueFormHtml(data, "BRANCH_ID");
		String transAmt = XmlUtil.getTagValueFormHtml(data, "TRANS_AMT");
		String remark = XmlUtil.getTagValueFormHtml(data, "REMARK");
		
		Money money = new Money();
		money.setCent(Integer.parseInt(orderAmt));
		orderAmt = money.getYuan();
		
		PayRequestParams param = new PayRequestParams();
		param.setMerCertNo(merCertNo);
		param.setMerDate(merDate);
		param.setMerId(merId);
		param.setAccName(accName);
		param.setAccNo(accNo);
		param.setAuthCode(authCode);
		param.setBankRefNo(bankRefNo);
		param.setBranchId(branchId);
		param.setCertiCode(certiCode);
		param.setClearingOrderId(clearingOrderId);
		param.setOrderAmt(orderAmt);
		param.setOrderId(orderId);
		param.setPayAcctName(payAcctName);
		param.setPayAcctNo(payAcctNo);
		param.setPayBankName(payBankName);
		param.setPayReturn(payReturn);
		param.setPhone(phone);
		param.setRemark(remark);
		param.setSendDate(sendDate);
		param.setSendTime(sendTime);
		param.setTransAmt(transAmt);
		
		PayResposeRarams doPay = payTransService.doPay(param);
		
		String json = JsonUtil.toJson(doPay);
		byte[] signByPublicKey = rsa.SignByPublicKey(json.getBytes("UTF-8"));
		try {
			response.getOutputStream().write(signByPublicKey);
		} catch (IOException e) {
			logger.error("返回失败",e);
		}
		
	}
	
}
