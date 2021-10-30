package com.hatcher.service;

import com.hatcher.entity.Group;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-25
 */
public interface IGroupService extends IService<Group> {
    /**
     * 添加组别信息
     * @param group 组
     * @return
     */
    int AddGroupInfo(Group group);
}
