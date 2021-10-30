package com.hatcher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.User;
import com.hatcher.dao.UserMapper;
import com.hatcher.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
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
    public User login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        return userDao.selectOne(queryWrapper);
    }

    @Override
    public int register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean exist = isExist(username);
        if (exist) {
            return USERNAME_EXIST;
        } else {
            return userDao.insert(user);
        }
    }

    private boolean isExist(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        User user = userDao.selectOne(queryWrapper);
        return user != null;
    }
}
