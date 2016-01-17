package com.gbz.myblog.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class LineNumberMapperTest extends SpringMVCTestContent{

	@Autowired
	LineNumberMapper lineNumberMapper;
	
	@Test
	public void getLineNumberByIdTest(){
		assertNotEquals(null, lineNumberMapper.getLineNumberById(1));
		assertEquals(null, lineNumberMapper.getLineNumberById(-1));
	}
}
