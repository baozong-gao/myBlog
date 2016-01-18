package com.gbz.myblog.service.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbz.myblog.bean.LineNumberVo;
import com.gbz.myblog.bean.view.PayRequestParams;
import com.gbz.myblog.mapper.LineNumberMapper;
import com.gbz.myblog.util.JsonUtil;
import com.gbz.myblog.util.SystemErrorException;

@Service
public class LineNumberServiceImpl {
	private static final Logger logger = LoggerFactory
			.getLogger(LineNumberServiceImpl.class);
	@Autowired
	public LineNumberMapper lineNumberMapper;

	public void setLineNumberToPayVo(PayRequestParams param)
			throws SystemErrorException {
		try {
			String branchId = param.getBranchId();
			int id = Integer.parseInt(branchId);
			LineNumberVo lineNumber = lineNumberMapper.getLineNumberById(id);
			logger.debug("联行号【{}】，信息为：【{}】", id, JsonUtil.toJson(lineNumber));
			param.setLineNumber(lineNumber);
		} catch (Exception e) {
			throw new SystemErrorException("初始化联行号失败", e);
		}
	}

}
