package com.fastech.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fastech.entity.Dictionary;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface DictionaryDAO {
	List<Dictionary> getDictionaryByType(@Param(value="type") String type);
}
