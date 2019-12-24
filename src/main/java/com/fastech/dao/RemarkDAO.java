package com.fastech.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fastech.entity.Remark;
import com.fastech.entity.vo.RemarkVO;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface RemarkDAO {

	void insertRemark(Remark remark);

	List<RemarkVO> getRemarkById(@Param(value = "blogid")String blogid);

	
}
