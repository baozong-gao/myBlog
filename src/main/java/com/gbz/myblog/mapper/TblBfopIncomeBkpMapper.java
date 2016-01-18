package com.gbz.myblog.mapper;

import org.springframework.stereotype.Repository;

import com.gbz.myblog.bean.TblBfopIncomeBkpVo;

@Repository
public interface TblBfopIncomeBkpMapper {

	public int addTransRecordBleak(TblBfopIncomeBkpVo vo);
	
	public int updateTransRecordBleak(TblBfopIncomeBkpVo vo);
	
	public TblBfopIncomeBkpVo getTransRecordBleakByTransId(int id);
	
}
