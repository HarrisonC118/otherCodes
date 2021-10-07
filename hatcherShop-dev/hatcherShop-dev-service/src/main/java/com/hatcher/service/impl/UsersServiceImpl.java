package com.hatcher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.bo.UserBO;
import com.hatcher.entity.Users;
import com.hatcher.enums.Sex;
import com.hatcher.mapper.UsersMapper;
import com.hatcher.service.IUsersService;
import com.hatcher.utils.DateUtil;
import com.hatcher.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 用户表  服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    private UsersMapper usersDao;

    public static final String DEFAULT_USER_FACE = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180520%2F0473e00bdfd2476fbe0c228a45a1652c.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1636110265&t=af239fff724436d01384f5c06f32307b";

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = {Exception.class})
    public boolean queryUsernameIsExist(String username) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Users users = usersDao.selectOne(queryWrapper);
        return users != null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Users createUser(UserBO userBO) {
        Users user = new Users();
        user.setUsername(userBO.getUsername());
        try {
            // 对密码进行MD5加密
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 昵称默认与用户名一样
        user.setNickname(userBO.getUsername());
        // 设置默认头像
        user.setFace(DEFAULT_USER_FACE);
        // 通过传入的字符串获得Date类型的数据，但是entity的生日是localDate类型的，所以需要转换
        user.setBirthday(DateUtil.stringToLocalDate("1999-09-09"));
        // 生日类型使用枚举
        user.setSex(Sex.secret.type);
        user.setCreatedTime(DateUtil.dateToLocalDateTime(new Date()));
        user.setUpdatedTime(DateUtil.dateToLocalDateTime(new Date()));
        System.out.println(user);
        usersDao.insert(user);
        return user;
    }
}
