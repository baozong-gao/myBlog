package com.gbz.myblog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gbz.myblog.bean.TblBfopOutcomeRecordVo;

@Repository
public interface TblBfopOutcomeRecordMapper {
	
	public int addTransRecord(TblBfopOutcomeRecordVo vo);
	
	public int updateTransRecord(TblBfopOutcomeRecordVo vo);
	
	public TblBfopOutcomeRecordVo getTransRecordByOutcomeId(int id);
	
	public List<TblBfopOutcomeRecordVo> getTransRecordByRecvDate(String date);

	public List<TblBfopOutcomeRecordVo> getTransRecordBySendDateAndSeq(@Param("sendDate") String sendDate,@Param("seq") String seq);

}
