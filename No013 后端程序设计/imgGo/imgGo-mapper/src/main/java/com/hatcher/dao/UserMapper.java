package com.hatcher.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hatcher.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
