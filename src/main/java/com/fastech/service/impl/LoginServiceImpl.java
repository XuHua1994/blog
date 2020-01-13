package com.fastech.service.impl;

import com.fastech.base.Return;
import com.fastech.dao.UserDAO;
import com.fastech.entity.User;
import com.fastech.service.LoginService;
import com.fastech.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDAO userDao;


	@Override
	public Return loginUser(Map<String, String> inputMap, HttpServletRequest request) {
		String username = inputMap.get("username");
		String password = inputMap.get("password");
		User user = userDao.getLoginUser(username, password);
		if (user == null) {
			return new Return(false, "用户名或者密码错误!");
		} else {
            HttpSession session =request.getSession(true);
            session.setAttribute("user", user);
            session.setAttribute("isLogin", "true");
            session.setMaxInactiveInterval(10 * 60);
			return new Return(true, "success");
		}
	}

	@Override
	public void registerUser(User user, HttpServletRequest request) {
		Timestamp time = TimeUtils.getTime();
		user.setId(UUID.randomUUID().toString());
		user.setCreatetime(time);
		user.setUpdatetime(time);
		userDao.insertUser(user);
		HttpSession session =request.getSession(true);
		session.setAttribute("user", user);
		session.setAttribute("isLogin", "true");
		session.setMaxInactiveInterval(10 * 60);
	}
}
