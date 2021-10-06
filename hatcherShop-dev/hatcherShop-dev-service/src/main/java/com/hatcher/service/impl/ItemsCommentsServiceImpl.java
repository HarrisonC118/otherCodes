package com.hatcher.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.ItemsComments;
import com.hatcher.mapper.ItemsCommentsMapper;
import com.hatcher.service.IItemsCommentsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价表  服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Service
public class ItemsCommentsServiceImpl extends ServiceImpl<ItemsCommentsMapper, ItemsComments> implements IItemsCommentsService {

}
