package com.hatcher.service.impl;

import com.hatcher.entity.User;
import com.hatcher.mapper.UserMapper;
import com.hatcher.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
