package com.hatcher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.bo.UserLoginBo;
import com.hatcher.bo.UserRegisterBo;
import com.hatcher.dao.UserMapper;
import com.hatcher.entity.User;
import com.hatcher.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-08
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	private static final Integer USERNAME_EXIST = -1;
	@Autowired
	private UserMapper userDao;

	@Override
	public User login(UserLoginBo user) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", user.getUsername());
		queryWrapper.eq("password", user.getPassword());
		return userDao.selectOne(queryWrapper);
	}

	@Override
	public int register(UserRegisterBo registerInfo) {
		User user = new User();
		user.setUsername(registerInfo.getUsername());
		user.setPassword(registerInfo.getPassword());
		boolean exist = isUsernameExist(user.getUsername());
		if (exist) {
			return USERNAME_EXIST;
		} else {
			return userDao.insert(user);
		}
	}

	@Override
	public boolean isIdExist(String userId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("id", userId);
		User user = userDao.selectOne(queryWrapper);
		return user != null;
	}

	private boolean isUsernameExist(String username) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("username", username);
		User user = userDao.selectOne(queryWrapper);
		return user != null;
	}
}
