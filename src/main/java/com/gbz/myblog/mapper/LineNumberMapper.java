package com.gbz.myblog.mapper;

import org.springframework.stereotype.Repository;

import com.gbz.myblog.bean.LineNumberVo;

@Repository
public interface LineNumberMapper {

	public LineNumberVo getLineNumberById(int id);
}
