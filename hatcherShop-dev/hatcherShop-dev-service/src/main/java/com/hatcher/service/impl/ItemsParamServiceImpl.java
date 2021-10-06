package com.hatcher.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.ItemsParam;
import com.hatcher.mapper.ItemsParamMapper;
import com.hatcher.service.IItemsParamService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品参数  服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Service
public class ItemsParamServiceImpl extends ServiceImpl<ItemsParamMapper, ItemsParam> implements IItemsParamService {

}
