package com.hatcher.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.UserAddress;
import com.hatcher.mapper.UserAddressMapper;
import com.hatcher.service.IUserAddressService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户地址表  服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {

}
