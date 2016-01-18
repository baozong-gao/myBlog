package com.gbz.myblog.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gbz.myblog.bean.TblBfopOutcomeRecordVo;
import com.gbz.myblog.bean.view.PayRequestParams;
import com.gbz.myblog.bean.view.PayResposeRarams;


public interface TblBfopOutcomeRecordService {
	
	public int addTransRecord(TblBfopOutcomeRecordVo vo);
	
	public int initTransRecord(PayRequestParams param);
	
	public int updateTransRecord(PayRequestParams param,PayResposeRarams res);
	
	public int updateTransRecord(TblBfopOutcomeRecordVo vo);
	
	public TblBfopOutcomeRecordVo getTransRecordByOutcomeId(int id);
	
	public List<TblBfopOutcomeRecordVo> getTransRecordByRecvDate(String date);

	public List<TblBfopOutcomeRecordVo> getTransRecordBySendDateAndSeq(@Param("sendDate") String sendDate,@Param("seq") String seq);

}
