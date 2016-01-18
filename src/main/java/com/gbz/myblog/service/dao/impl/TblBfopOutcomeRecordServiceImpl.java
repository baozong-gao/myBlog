package com.gbz.myblog.service.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbz.myblog.bean.TblBfopOutcomeRecordVo;
import com.gbz.myblog.bean.Enum.TransStatusEnum;
import com.gbz.myblog.bean.view.PayRequestParams;
import com.gbz.myblog.bean.view.PayResposeRarams;
import com.gbz.myblog.mapper.TblBfopOutcomeRecordMapper;
import com.gbz.myblog.service.dao.TblBfopOutcomeRecordService;
import com.gbz.myblog.util.DateUtil;

@Service
public class TblBfopOutcomeRecordServiceImpl implements TblBfopOutcomeRecordService{
    
	@Autowired
	TblBfopOutcomeRecordMapper tblBfopOutcomeRecordMapper;
	
	@Override
	public int initTransRecord(PayRequestParams vo) {
		TblBfopOutcomeRecordVo transRecord = new TblBfopOutcomeRecordVo();
		transRecord.setOutcomeId(vo.getOrderId());
		transRecord.setRecvDate(DateUtil.getCurrentDate());
		transRecord.setRecvTime(DateUtil.getCurrentTime());
		transRecord.setTransAmt(vo.getTransAmt());
		transRecord.setTransStatus(TransStatusEnum.I.toString());
		transRecord.setAcctName(vo.getAccName());
		transRecord.setAcctNo(vo.getAccNo());
		transRecord.setSendDate(DateUtil.getCurrentDate());
		transRecord.setSendTime(DateUtil.getCurrentTime());
		transRecord.setBranchId(vo.getBranchId());
		return addTransRecord(transRecord);
	}

	@Override
	public int updateTransRecord(TblBfopOutcomeRecordVo vo) {
		return tblBfopOutcomeRecordMapper.updateTransRecord(vo);
	}

	@Override
	public TblBfopOutcomeRecordVo getTransRecordByOutcomeId(int id) {
		return tblBfopOutcomeRecordMapper.getTransRecordByOutcomeId(id);
	}

	@Override
	public List<TblBfopOutcomeRecordVo> getTransRecordByRecvDate(String date) {
		return tblBfopOutcomeRecordMapper.getTransRecordByRecvDate(date);
	}

	@Override
	public List<TblBfopOutcomeRecordVo> getTransRecordBySendDateAndSeq(
			String sendDate, String seq) {
		return tblBfopOutcomeRecordMapper.getTransRecordBySendDateAndSeq(sendDate, seq);
	}

	@Override
	public int addTransRecord(TblBfopOutcomeRecordVo vo) {
		return tblBfopOutcomeRecordMapper.addTransRecord(vo);
	}

	@Override
	public int updateTransRecord(PayRequestParams param,PayResposeRarams res) {
		TblBfopOutcomeRecordVo transRecord = new TblBfopOutcomeRecordVo();
		transRecord.setChannelReturnCode(res.getBankReturnCode());
		transRecord.setChannelReturnMsg(res.getBankReturnMsg());
		transRecord.setChannelReturnSeq1(res.getBankTranId());
		transRecord.setChannelBatchId(res.getBankBatchid());
		transRecord.setChannelReturnDate(res.getSendDate());
		transRecord.setChannelReturnTime(res.getSendTime());
		transRecord.setTransStatus(res.getRespType());
		return updateTransRecord(transRecord);
	}

}
