package com.hatcher.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.ItemsSpec;
import com.hatcher.mapper.ItemsSpecMapper;
import com.hatcher.service.IItemsSpecService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计 服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Service
public class ItemsSpecServiceImpl extends ServiceImpl<ItemsSpecMapper, ItemsSpec> implements IItemsSpecService {

}
