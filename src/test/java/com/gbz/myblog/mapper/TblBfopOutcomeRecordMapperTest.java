package com.gbz.myblog.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

import com.gbz.myblog.bean.TblBfopOutcomeRecordVo;

@TransactionConfiguration(defaultRollback = false)
public class TblBfopOutcomeRecordMapperTest extends SpringMVCTestContent{
	
	@Autowired
	TblBfopOutcomeRecordMapper tblBfopOutcomeRecordMapper;
	
	@Test
	@Transactional()
	public void addTransRecordTest(){
		TblBfopOutcomeRecordVo vo = new TblBfopOutcomeRecordVo();
		vo.setOutcomeId("1");
		vo.setRecvDate("20160117");
		vo.setRecvTime("220711");
		vo.setTransAmt("1");
		vo.setTransStatus("I");
		vo.setAcctName("gbz");
		vo.setAcctNo("0011");
		vo.setSendDate("20160117");
		vo.setSendTime("220711");
		vo.setBranchId("11");
		assertEquals(1, tblBfopOutcomeRecordMapper.addTransRecord(vo));
	}
	
	@Test(expected=Exception.class)
	public void addTransRecordNullVoTest(){
		TblBfopOutcomeRecordVo vo1 = new TblBfopOutcomeRecordVo();
		tblBfopOutcomeRecordMapper.addTransRecord(vo1);
	}
	
	@Test(expected=Exception.class)
	public void addTransRecordNullTest(){
		tblBfopOutcomeRecordMapper.addTransRecord(null);
	}
	
	@Test
	public void updateTransRecordTest(){
		TblBfopOutcomeRecordVo vo = new TblBfopOutcomeRecordVo();
		vo.setOutcomeId("1");
		vo.setTransStatus("S");
		vo.setAcctName("gbz1111");
		vo.setChannelReturnSeq1("11");
		assertEquals(1, tblBfopOutcomeRecordMapper.updateTransRecord(vo));
	}
	@Test
	public void getTransRecordTest(){
		assertEquals(null, tblBfopOutcomeRecordMapper.getTransRecordByOutcomeId(-1));
		assertEquals(0, tblBfopOutcomeRecordMapper.getTransRecordByRecvDate("-1").size());
		assertEquals(0, tblBfopOutcomeRecordMapper.getTransRecordBySendDateAndSeq("-1", "-1").size());
		
		assertNotEquals(null, tblBfopOutcomeRecordMapper.getTransRecordByOutcomeId(1));
		assertEquals(1, tblBfopOutcomeRecordMapper.getTransRecordByRecvDate("20160117").size());
		assertEquals(1, tblBfopOutcomeRecordMapper.getTransRecordBySendDateAndSeq("20160117", "11").size());
	
		
	}
}
