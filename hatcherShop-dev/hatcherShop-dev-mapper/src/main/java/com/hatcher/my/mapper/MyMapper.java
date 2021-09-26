package com.hatcher.my.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author: HatcherCheung
 * Date:  2021/9/18
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
