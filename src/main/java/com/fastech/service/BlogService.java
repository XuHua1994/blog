package com.fastech.service;


import java.util.Map;

import com.fastech.base.NewReturn;
import com.fastech.base.Return;
import com.fastech.entity.User;

public interface BlogService {

	Return getBolgByUid(String uid);

	Return writeBlog(Map<String, Object> inputMap, User user);
	
	NewReturn getBlogs(Map<String, Object> inputMap);

	Return getBlogById(Map<String, Object> inputMap);

	Return writeRemark(Map<String, Object> inputMap, User user);

	Return getRemarkById(Map<String, Object> inputMap);
}
