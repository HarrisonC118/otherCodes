package com.hatcher.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.Items;
import com.hatcher.mapper.ItemsMapper;
import com.hatcher.service.IItemsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Service
public class ItemsServiceImpl extends ServiceImpl<ItemsMapper, Items> implements IItemsService {

}
