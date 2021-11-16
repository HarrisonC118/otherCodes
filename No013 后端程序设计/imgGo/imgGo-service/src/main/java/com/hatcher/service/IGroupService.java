package com.hatcher.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hatcher.bo.AddGroupBo;
import com.hatcher.entity.Group;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-25
 */
public interface IGroupService extends IService<Group> {
	/**
	 * 添加组别信息
	 *
	 * @param groupBo 组
	 * @return
	 */
	int addGroupInfo(AddGroupBo groupBo);
}
