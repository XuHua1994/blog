package com.fastech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastech.base.Return;
import com.fastech.dao.DictionaryDAO;
import com.fastech.entity.Dictionary;
import com.fastech.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService{

	@Autowired
	private DictionaryDAO dictionaryDAO;

	@Override
	public Return getDictionaryByType(String type) {
		List<Dictionary> dictList= dictionaryDAO.getDictionaryByType(type);
		return new Return(true,dictList,"success");
	}
	
	
}
