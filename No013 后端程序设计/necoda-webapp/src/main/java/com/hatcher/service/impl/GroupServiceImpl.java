package com.hatcher.service.impl;

import com.hatcher.dao.UserMapper;
import com.hatcher.entity.Group;
import com.hatcher.dao.GroupMapper;
import com.hatcher.entity.User;
import com.hatcher.service.IGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-25
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements IGroupService {
    @Autowired
    private GroupMapper groupDao;
    @Autowired
    private UserMapper userDao;
    @Override
    public int AddGroupInfo(Group group) {
        String userId = group.getUserId();
        User user = userDao.selectById(userId);
        if (user != null) {
            return groupDao.insert(group);
        }
        return -1;
    }
}
